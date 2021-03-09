package com.itz.cloud.mapper;

import com.itz.cloud.pojo.User;

import java.util.List;

public interface UserMapper {

  List<User> getAllUser();

  Integer addUser(User user);

  Integer addUser2(User user);

  Integer deleteUserById(Long id);

  Integer updateUserById(User user);
}
