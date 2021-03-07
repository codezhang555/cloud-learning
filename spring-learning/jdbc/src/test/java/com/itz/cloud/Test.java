package com.itz.cloud;

import com.itz.cloud.jdbc.AccountService;
import com.itz.cloud.jdbc.JavaConfig;
import com.itz.cloud.jdbc.User;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/8 0:23
 */
public class Test {

    JdbcTemplate jdbcTemplate;
    AccountService accountService;

    @Before
    public void before(){
        //通过java代码
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        //通过xml配置
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        accountService = ctx.getBean(AccountService.class);
    }

    @org.junit.Test
    public void test01(){
        jdbcTemplate.update("insert into user(name,address,favorites) values (?,?,?);","张则天","中国南京","coding");
    }

    @org.junit.Test
    public void test02(){
        jdbcTemplate.update("update user set name = ? where id = ?;","张总",8);
    }

    @org.junit.Test
    public void test03(){
        jdbcTemplate.update("delete from user where id = ?;",8);
    }

    @org.junit.Test
    public void test04(){
        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        System.out.println("list = " + list);
    }

    @org.junit.Test
    public void test05(){
        accountService.updateMoney();
    }


}
