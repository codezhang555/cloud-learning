package com.itz.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;
import com.itz.cloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @PackageName: com.itz.cloud.service.impl
 * @ClassName: UserServiceImpl
 * @Author: codeZhang
 * @DateTime: 2021/1/28 13:45
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private RestTemplate restTemplate;
  @Value("${service-url.user-service}")
  private String userServiceUrl;

  /**
   * @HystrixCommand中的常用参数
   *    fallbackMethod：指定服务降级处理方法；
   *    ignoreExceptions：忽略某些异常，不发生服务降级；
   *    commandKey：命令名称，用于区分不同的命令；
   *    groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
   *    threadPoolKey：线程池名称，用于划分线程池。
   *
   * @param id
   * @return
   */
  @Override
  @HystrixCommand(fallbackMethod = "getDefaultUser")
  public CommonResult getUserId(Long id) {
    return restTemplate.getForObject(userServiceUrl + "/user/{1}",CommonResult.class,id);
  }

  /**
   * 设置，命令，线程池名称
   * @param id
   * @return
   */
  @Override
  @HystrixCommand(fallbackMethod = "getDefaultUser",
                  commandKey = "getUserCommand",
                  groupKey = "getUserGroup",
                  threadPoolKey = "getUserThreadPool")
  public CommonResult getUserCommand(Long id) {
    return restTemplate.getForObject(userServiceUrl + "/user/{1}",CommonResult.class,id);
  }

  /**
   * 忽略异常方法
   * @param id
   * @return
   */
  @Override
  @HystrixCommand(fallbackMethod = "getDefaultUser2",ignoreExceptions = {NullPointerException.class})
  public CommonResult getUserException(Long id) {
    if (id == 1){
      throw new IndexOutOfBoundsException();
    }else if (id == 2){
      throw new NullPointerException();
    }
    return restTemplate.getForObject(userServiceUrl + "/user/{1}",CommonResult.class,id);
  }

  /**
   *  Hystrix的请求缓存：
   *    * 当系统并发量越来越大时，我们需要使用缓存来优化系统，达到减轻并发请求线程数，提供响应速度的效果。
   *    * 相关注解：
   *    * @CacheResult：开启缓存，默认所有参数作为缓存的key，cacheKeyMethod可以通过返回String类型的方法指定key；
   *    * @CacheKey：指定缓存的key，可以指定参数或指定参数中的属性值为缓存key，cacheKeyMethod还可以通过返回String类型的方法指定；
   *    * @CacheRemove：移除缓存，需要指定commandKey。
   * @param id
   */
  @Override
  @CacheResult(cacheKeyMethod = "getCacheKey")
  @HystrixCommand(fallbackMethod = "getDefaultUser",commandKey = "getUserCache")
  public CommonResult getUserCache(Long id) {
    LOGGER.info("getUserCache id:{}",id);
    return restTemplate.getForObject(userServiceUrl + "/user/{1}",CommonResult.class,id);
  }

  /**
   * 测试移除缓存
   * @param id
   * @return
   */
  @Override
  @HystrixCommand
  @CacheRemove(commandKey = "getUserCache",cacheKeyMethod = "getCacheKey")
  public CommonResult removeCache(Long id) {
    LOGGER.info("removeCache id:{}",id);
    return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}",null,CommonResult.class,id);
  }

  /**
   * 请求合并方法
   * @param id
   * @return
   */
  @Override
  @HystrixCollapser(batchMethod = "getUserByIds",collapserProperties = {
      @HystrixProperty(name = "timerDelayInMilliseconds",value = "100")
  })
  public Future<User> getUserFuture(Long id) {
    return new AsyncResult<User>() {
      @Override
      public User invoke() {
        CommonResult commonResult = restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
        Map data = (Map) commonResult.getData();
        User user = BeanUtil.mapToBean(data, User.class, true);
        LOGGER.info("getUserById username:{}",user.getUsername());
        return user;
      }
    };
  }

  @HystrixCommand
  public List<User> getUserByIds(List<Long> ids){
    LOGGER.info("getUserByIds:{}",ids);
    CommonResult commonResult = restTemplate.getForObject(userServiceUrl + "/user/getUserByIds?ids={1}", CommonResult.class, CollUtil.join(ids, ","));
    return (List<User>) commonResult.getData();
  }

  /**
   * 为缓存生成key的方法
   * @param id
   * @return
   */
  public String getCacheKey(Long id){
    return String.valueOf(id);
  }

  /**
   * 服务降级方法
   * @param id
   * @return
   */
  public CommonResult getDefaultUser(@PathVariable Long id){
    User defaultUser = new User(-1L, "defaultUser", "123456");
    return new CommonResult<>(defaultUser);
  }

  /**
   * 忽略异常服务降级方法
   * @param id
   * @param e
   * @return
   */
  public CommonResult getDefaultUser2(@PathVariable Long id, Throwable e) {
    LOGGER.error("getDefaultUser2 id:{},throwable class:{}", id, e.getClass());
    User defaultUser = new User(-2L, "defaultUser2", "123456");
    return new CommonResult<>(defaultUser);
  }


}
