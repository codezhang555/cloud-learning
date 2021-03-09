package com.itz.cloud.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @PackageName: com.itz.cloud.utils
 * @ClassName: SqlSessionFactoryUtils
 * @Author: codeZhang
 * @DateTime: 2021/3/9 13:51:31
 * @Version 1.0
 */
public class SqlSessionFactoryUtils {
  private static SqlSessionFactory SQLSESSIONFACTORY;

  public static SqlSessionFactory getInstances(){
    if (SQLSESSIONFACTORY == null){
      try {
        SQLSESSIONFACTORY = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return SQLSESSIONFACTORY;
  }
}
