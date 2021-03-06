package com.itz.cloud.service;

import com.itz.cloud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.service
 * @Version 1.0
 * @date 2021/3/6 23:24
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<String> getAllUsers(){
        String hello = userDao.hello();
        System.out.println("hello = " + hello);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("zh" + i);
        }
        return users;
    }
}
