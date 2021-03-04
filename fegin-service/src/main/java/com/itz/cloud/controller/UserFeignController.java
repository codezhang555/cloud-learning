package com.itz.cloud.controller;

import com.itz.cloud.domain.CommonResult;
import com.itz.cloud.domain.User;
import com.itz.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PackageName: cn.itz.cloud.controller
 * @ClassName: UserFeignController
 * @Author: codeZhang
 * @DateTime: 2021/2/1 11:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public CommonResult getUser(@PathVariable Long id){
    return userService.getUser(id);
  }

  @GetMapping("/getByUsername")
  public CommonResult getByUsername(@RequestParam String username) {
    return userService.getByUsername(username);
  }

  @PostMapping("/create")
  public CommonResult create(@RequestBody User user) {
    return userService.create(user);
  }

  @PostMapping("/update")
  public CommonResult update(@RequestBody User user) {
    return userService.update(user);
  }

  @PostMapping("/delete/{id}")
  public CommonResult delete(@PathVariable Long id) {
    return userService.delete(id);
  }
}
