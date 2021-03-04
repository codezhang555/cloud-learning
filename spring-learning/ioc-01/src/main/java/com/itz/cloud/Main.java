package com.itz.cloud;

import com.itz.cloud.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/4 23:14
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        m1(context);
//        m2(context);
        User u5 = context.getBean("user3", User.class);
        System.out.println("u5 = " + u5);
    }

    private static void m2(ClassPathXmlApplicationContext context) {
        User u4 = context.getBean("user2", User.class);
        System.out.println("u4 = " + u4);
    }

    private static void m1(ClassPathXmlApplicationContext context) {
        User u1 = (User) context.getBean("user");
        System.out.println("u1 = " + u1);
        User u2 = context.getBean("user", User.class);
        System.out.println("u2 = " + u2);
        User u3 = context.getBean(User.class);
        System.out.println("u3 = " + u3);
    }
}
