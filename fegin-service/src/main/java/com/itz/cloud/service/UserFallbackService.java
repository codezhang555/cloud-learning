package com.itz.cloud.service;

import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;
import org.springframework.stereotype.Component;

/**
 * UserService服务降级方法
 * @PackageName: cn.itz.cloud.service
 * @ClassName: UserFallbackService
 * @Author: codeZhang
 * @DateTime: 2021/2/1 11:12
 * @Version 1.0
 */
@Component
public class UserFallbackService implements UserService {

  @Override
  public CommonResult create(User user) {
    User defaultUser = new User(-1L, "defaultUser", "123456");
    return new CommonResult<>(defaultUser);
  }

  @Override
  public CommonResult<User> getUser(Long id) {
    User defaultUser = new User(-1L, "defaultUser", "123456");
    return new CommonResult<>(defaultUser);
  }

  @Override
  public CommonResult<User> getByUsername(String username) {
    User defaultUser = new User(-1L, "defaultUser", "123456");
    return new CommonResult<>(defaultUser);
  }

  @Override
  public CommonResult update(User user) {
    return new CommonResult("调用失败，服务被降级",500);
  }

  @Override
  public CommonResult delete(Long id) {
    return new CommonResult("调用失败，服务被降级",500);
  }
}
