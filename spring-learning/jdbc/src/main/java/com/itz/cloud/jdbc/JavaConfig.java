package com.itz.cloud.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.jdbc
 * @Version 1.0
 * @date 2021/3/8 0:19
 */
@Configuration
@ComponentScan
public class JavaConfig {

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test01?serverTimeZone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
