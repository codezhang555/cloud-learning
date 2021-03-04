package com.itz.cloud.test.String1;

import org.junit.Test;

/**
 * 关于StringBuffer 和 StringBuilder的使用
 *
 *
 * @author CodeZhang
 * @date 2020/5/1 18:52
 */
public class StringBufferBuilderTest {
    /**
     * 面试题：String、StringBuffer、StringBuilder的区别？
     * String: 不可变的字符序列；底层结构使用char[]储存
     * StringBuffer: 可变的字符序列：线程安全，效率慢；底层结构使用char[]储存
     * StringBuilder: 可变的字符序列：jdk5.0新增，线程不安全，效率高（不存在多线程线程安全问题，就用这个）；底层结构使用char[]储存
     *
     *
     * 源码分析：
     *  String str = new String(); //new char[0];
     *  String str1 = new String("abc"); //new char[]{'a','b','c'};
     *
     *  StringBuffer sb1 = new StringBuffer(); //new char[16];底层创建了一个长度是16的数组
     *  System.out.println(sb1.length()); // 0
     *  sb1.append('a'); //value[0] = 'a';
     *  sb1.append('b'); //value[1] = 'b';
     *
     *  StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length+16]
     *
     *  问题1：System.out.println(sb2.length()); // 3
     *  问题2：扩容问题：如果添加的数据底层数据放不下了，那就需要扩容底层的数组,
     *                默认情况下扩容为原来容量的2倍+22，同时将原有数组中的元素复制到新的数组中
     *
     *        开发中尽量使用StringBuffer(int capacity) 或 StringBuilder(int capacity)
     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length()); // 0
    }
}
