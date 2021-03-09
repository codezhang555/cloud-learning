package com.itz.cloud;

import com.itz.cloud.pojo.User;
import com.itz.cloud.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: MyTest
 * @Author: codeZhang
 * @DateTime: 2021/3/9 14:04:03
 * @Version 1.0
 */
public class MyTest {
  private SqlSession sqlSession;

  @Before
  public void before(){
    sqlSession = SqlSessionFactoryUtils.getInstances().openSession();
  }

  @Test
  public void addUser(){
    User user = new User();
    user.setUsername("测试");
    user.setAddress("南京");
    int insert = sqlSession.insert("com.itz.cloud.mapper.UserMapper.addUser", user);
    System.out.println("insert = " + insert);
    sqlSession.commit();
  }

  @After
  public void after(){
    sqlSession.close();
  }
}
