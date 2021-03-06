package com.itz.cloud;

import com.itz.cloud.config.JavaConfig;
import com.itz.cloud.config.SayHello;
import com.itz.cloud.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/6 23:18
 */
public class JavaConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        //通过名字获取
        SayHello sayHello = ctx.getBean("sh", SayHello.class);
        System.out.println("sayHello = " + sayHello.sayHello("zhang"));
        //通过类型获取
        UserService userService = ctx.getBean(UserService.class);
        List<String> allUsers = userService.getAllUsers();
        System.out.println("allUsers = " + allUsers);
    }
}
