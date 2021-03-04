package com.itz.cloud.service;

import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;

import java.util.concurrent.Future;

/**
 * @PackageName: com.itz.cloud.service
 * @ClassName: UserService
 * @Author: codeZhang
 * @DateTime: 2021/1/28 13:44
 * @Version 1.0
 */
public interface UserService {
  CommonResult getUserId(Long id);

  CommonResult getUserCommand(Long id);

  CommonResult getUserException(Long id);

  CommonResult getUserCache(Long id);

  CommonResult removeCache(Long id);

  Future<User> getUserFuture(Long id);
}
