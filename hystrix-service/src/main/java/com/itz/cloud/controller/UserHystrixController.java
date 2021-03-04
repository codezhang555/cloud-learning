package com.itz.cloud.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;
import com.itz.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @PackageName: com.itz.cloud.controller
 * @ClassName: UserHystrixController
 * @Author: codeZhang
 * @DateTime: 2021/1/28 13:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController {

  @Autowired
  private UserService userService;

  /**
   * 服务降级测试接口
   * @param id
   * @return
   */
  @GetMapping("/testFallback/{id}")
  public CommonResult testFallBack(@PathVariable Long id){
    return userService.getUserId(id);
  }

  /**
   * 设置命令，分组及线程池名称
   * @param id
   * @return
   */
  @GetMapping("/testCommand/{id}")
  public CommonResult testCommand(@PathVariable Long id){
    return userService.getUserCommand(id);
  }

  /**
   * 忽略异常服务接口
   * @param id
   * @return
   */
  @GetMapping("/testException/{id}")
  public CommonResult testException(@PathVariable Long id){
    return userService.getUserException(id);
  }

  /**
   * 测试使用缓存
   * @param id
   * @return
   */
  @GetMapping("/testCache/{id}")
  public CommonResult testCache(@PathVariable Long id){
    userService.getUserCache(id);
    userService.getUserCache(id);
    userService.getUserCache(id);
    return new CommonResult("操作成功",200);
  }

  /**
   * 测试移除缓存
   * @param id
   * @return
   */
  @GetMapping("/testRemoveCache/{id}")
  public CommonResult testRemoveCache(@PathVariable Long id){
    userService.getUserCache(id);
    userService.removeCache(id);
    userService.getUserCache(id);
    return new CommonResult("操作成功",200);
  }

  /**
   * 请求合并
   * 微服务系统中的服务间通信，需要通过远程调用来实现，随着调用次数越来越多，占用线程资源也会越来越多。
   * Hystrix中提供了@HystrixCollapser用于合并请求，从而达到减少通信消耗及线程数量的效果。
   * @HystrixCollapser 的常用属性
   *   1.batchMethod：用于设置请求合并的方法；
   *   2.collapserProperties：请求合并属性，用于控制实例属性，有很多；
   *   3.timerDelayInMilliseconds：collapserProperties中的属性，用于控制每隔多少时间合并一次请求；
   * @return
   */
  @GetMapping("/testCollapser")
  public CommonResult testCollapser() throws ExecutionException, InterruptedException {
    Future<User> future1 = userService.getUserFuture(1L);
    Future<User> future2 = userService.getUserFuture(2L);
    future1.get();
    future2.get();
    ThreadUtil.safeSleep(200);
    Future<User> future3 = userService.getUserFuture(3L);
    future3.get();
    return new CommonResult("操作成功",200);
  }
}
