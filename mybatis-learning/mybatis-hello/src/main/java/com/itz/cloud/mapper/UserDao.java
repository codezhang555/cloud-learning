package com.itz.cloud.mapper;

import com.itz.cloud.pojo.User;
import com.itz.cloud.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @PackageName: com.itz.cloud.mapper
 * @ClassName: UserDao
 * @Author: codeZhang
 * @DateTime: 2021/3/9 14:01:20
 * @Version 1.0
 */
public class UserDao {
  private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstances();

  /**
   * 添加
   * @param user
   * @return
   */
  public Integer addUser(User user){
    SqlSession sqlSession = sqlSessionFactory.openSession();
    int insert = sqlSession.insert("com.itz.cloud.mapper.UserMapper.addUser", user);
    sqlSession.commit();
    sqlSession.commit();
    return insert;
  }


}
