package com.itz.cloud.test.dateTest;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8 之前日期和时间的api测试
 *
 * @author CodeZhang
 * @date 2020/5/2 13:00
 */
public class DataTimeTest {

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    /**
     * java.util.Date类
     *         |---java.sql.Date类
     *
     * 1.两个构造器的使用
     *      构造器一：Date():创建一个对应当前时间的Date对象
     *      构造器二：创建指定毫秒数的Date对象
     * 2.两个方法的使用
     *      >toString():显示当前的年、月、日、时、分、秒
     *      >getTime():获取当前Date对象对应的毫秒数。（时间戳）
     * 3.java.sql.Date 对象的是数据库的日期时间的变量
     *      >如何实例化：
     *      >如何将java.util.Date对象转换为java.sql.Date对象
     *
     */
    @Test
    public void test2(){
        //构造器一：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString()); //Sat May 02 13:13:27 GMT+08:00 2020
        System.out.println(date1.getTime()); //1588396407751

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1588396407751L);
        System.out.println(date2);

        //创建java.sql.Date()
        java.sql.Date date3 = new java.sql.Date(33333333L);
        System.out.println(date3.toString());

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2154564545L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }


}
