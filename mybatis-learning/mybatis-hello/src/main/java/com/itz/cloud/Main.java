package com.itz.cloud;

import com.itz.cloud.pojo.User;
import com.itz.cloud.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: Main
 * @Author: codeZhang
 * @DateTime: 2021/3/9 13:53:47
 * @Version 1.0
 */
public class Main {
  public static void main(String[] args) {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getInstances();
    SqlSession sqlSession = factory.openSession();
//    m1(sqlSession);
//    m2(sqlSession);
//    m3(sqlSession);
//    m4(sqlSession);
    User user = new User();
    user.setId(1L);
    user.setUsername("张三");
    int update = sqlSession.update("com.itz.cloud.mapper.UserMapper.updateUserById", user);
    System.out.println("update = " + update);
    sqlSession.commit();
    sqlSession.close();
  }

  private static void m4(SqlSession sqlSession) {
    int delete = sqlSession.delete("com.itz.cloud.mapper.UserMapper.deleteUserById", 3);
    System.out.println("delete = " + delete);
    sqlSession.commit();
  }

  /**
   * 用mysql自带的UUID函数
   * id 需改成 String类型
   * @param sqlSession
   */
  private static void m3(SqlSession sqlSession) {
    User user = new User();
    user.setUsername("张橙子");
    user.setAddress("广州");
    int insert = sqlSession.insert("com.itz.cloud.mapper.UserMapper.addUser2", user);
    System.out.println("insert = " + insert);
    sqlSession.commit();
  }

  private static void m2(SqlSession sqlSession) {
    User user = new User();
    user.setUsername("测试");
    user.setAddress("南京");
    int insert = sqlSession.insert("com.itz.cloud.mapper.UserMapper.addUser", user);
    System.out.println("insert = " + insert);
    sqlSession.commit();
  }

  private static void m1(SqlSession sqlSession) {
    List<User> list = sqlSession.selectList("com.itz.cloud.mapper.UserMapper.getAllUser");
    for (User user : list) {
      System.out.println("user = " + user);
    }
  }
}
