package com.itz.cloud.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.jdbc
 * @Version 1.0
 * @date 2021/3/8 0:41
 */
@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void updateMoney(){
        jdbcTemplate.update("update account set money = money - 500 where name = ?","张三");
        int i = 1/0;
        jdbcTemplate.update("update account set money = money + 500 where name = ?","李四");
    }
}
