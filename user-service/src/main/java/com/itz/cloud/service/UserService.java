package com.itz.cloud.service;

import com.itz.cloud.domain.User;

import java.util.List;

/**
 * @PackageName: com.itz.cloud.service
 * @ClassName: UserService
 * @Author: codeZhang
 * @DateTime: 2021/1/28 11:09
 * @Version 1.0
 */
public interface UserService {
  void create(User user);

  User getUser(Long id);

  List<User> getUserByIds(List<Long> ids);

  User getByUsername(String username);

  void update(User user);

  void delete(Long id);
}
