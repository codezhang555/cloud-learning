package com.itz.cloud.test.dateTest;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * Jdk 8 新引入的日期时间api
 *
 * @author CodeZhang
 * @date 2020/5/3 12:46
 */
public class Jdk8NewDateApi {
    /**
     * LocalDate LocalTime LocalDateTime的使用
     * 说明：1.LocalDateTime比较于另外两个用的效率更高
     *      2. 类似于Calendar
     */
    @Test
    public void test1(){

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate===="+localDate);
        System.out.println("localTime===="+localTime);
        System.out.println("localDateTime===="+localDateTime);

        // of();   没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 5, 3, 12, 53);
        System.out.println("localDateTime1===="+localDateTime1);

        //getXxx() 获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());

        //withXxx()  体现了不可变性 设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //plusXxx()  添加相关属性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //minusXxx()  减少相关属性
        LocalDateTime localDateTime4 = localDateTime.minusMonths(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /**
     * DateTimeFormatter:格式化或解析日期，时间
     * 类似于SimpleDateFormat
     *
     */
    @Test
    public void test3(){
        //方式一：预定于的标准格式：如：ISO_LOCAL_DATE_TIME;ISO_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2020-05-03T13:37:31.054");
        System.out.println(parse);

        //方式二：本地化相关的格式：如：ofLocalizeDateTime(FormatStyle.LONG/FormatStyle.SHORT/FormatStyle.MEDIUM)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化：日期 --> 字符串
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        //本地化相关的格式：ofLocalizeDate(FormatStyle.LONG/FormatStyle.SHORT/FormatStyle.MEDIUM)
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        //格式化：日期 --> 字符串
        String str3 = formatter1.format(localDateTime);
        System.out.println(str3);



        //方式三：自定义的格式：如ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor parse1 = formatter3.parse("2020-05-03 13:52:02");
        System.out.println(parse1);


    }
}
