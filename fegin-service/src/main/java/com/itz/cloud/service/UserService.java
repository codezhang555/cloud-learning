package com.itz.cloud.service;

import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @PackageName: cn.itz.cloud.service
 * @ClassName: UserService
 * @Author: codeZhang
 * @DateTime: 2021/2/1 11:01
 * @Version 1.0
 */
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {

  @PostMapping("/user/create")
  CommonResult create(@RequestBody User user);

  @GetMapping("/user/{id}")
  CommonResult<User> getUser(@PathVariable Long id);

  @GetMapping("/user/getByUsername")
  CommonResult<User> getByUsername(@RequestParam String username);

  @PostMapping("/user/update")
  CommonResult update(@RequestBody User user);

  @PostMapping("/user/delete/{id}")
  CommonResult delete(@PathVariable Long id);

}
