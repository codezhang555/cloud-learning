package com.itz.cloud.test.dateTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8 之前的日期时间的api测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 *
 * @author CodeZhang
 * @date 2020/5/2 15:22
 */
public class DateTimeTest2 {
    /**
     * SimpleDateFormat的使用： 对日期Date类的格式化和解析
     *
     * 1.两个功能：
     * 1.1.格式化：日期 --> 字符串
     * 1.2.解析：格式化的逆过程 字符串 --> 日期
     *
     * 2.SimpleDateFormat的实例化
     *
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化:日期 --> 字符串
        Date date = new Date();
        //System.out.println(date);
        //格式化
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程 字符串 --> 日期
        String str = "20-5-2 下午3:29";
        Date date1 = sdf.parse(str);
        System.out.println(date1);


        System.out.println("**********按照指定的方式格式化和解析:调用带参数的构造器**************");
        //格式化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = sdf1.parse("2020-05-02 15:47:32");
        System.out.println(date2);
    }

    /**
     * 练习1：字符串“2020-09-08”转换为java.sql.Date
     *
     * 练习2：“三天打鱼两天晒网” 从1990-01-01开始  问****-**-**是 打鱼？晒网？
     *
     * 举例：2020-09-08？ 总天数
     *
     * 总天数 % 5 == 1，2,3 打鱼
     * 总天数 % 5 == 4,0 晒网
     *
     * 总天数的计算？
     * 方式一： (date2.getTime - date1.getTime()) /(1000*60*60*24)+1
     * 方式二： 1990-01-01 --> 2019-12-31 + 2020-01-01 --> 2020-09-08
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /**
     * Calendar日历类(抽象)的使用
     *
     * Calendar是可变的
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建它子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());

        /**2.常用方法
         *
         * get() 获取常用的属性信息
         * set()
         * add()
         * getTime()
         * setTime()
         */
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);   //这个月的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //今年的第几天

        calendar.set(Calendar.DAY_OF_MONTH,22);  //修改为这个月的第22天
        int days1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days1);

        calendar.add(Calendar.DAY_OF_MONTH,3);  //在这个月的第几天上加3天(负数就是减)
        int days2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days2);

        // getTime():日历类 --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime():Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }

}
