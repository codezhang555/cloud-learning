package com.itz.cloud.test.String1;

import org.junit.Test;

/**
 * String的使用
 *
 * @author CodeZhang
 * @date 2020/4/30 17:20
 */
public class StringTest {

    /**
     * String：字符串，使用一对""引起来表示
     * 1.String声明为final的，不可被继承
     * 2.String实现了Serializable（可序列化）接口，表示字符串是支持序列化的。
     *          实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String代表一个不可变的字符序列。简称：不可变性
     *      体现：1.当对字符串重新赋值时，需要重新制定内存区域赋值，不能使用原有的value进行赋值
     *           2.当对现有的字符串进行连接操作时，也需要重新制定内存区域赋值，不能使用原有的value进行赋值
     *           3.当调用String的replace()方法修改制定字符或字符串时，也需要重新制定内存区域赋值，不能使用原有的value进行赋值
     * 5.通过字面量的方式(区别于new)给一个字符串赋值，此时字符串值声明在字符串常量池中
     * 6.字符串常量池中是不会储存相同内容的字符串的
     *
     */

    @Test
    public void test1(){
        String s1 ="abc"; //字面量
        String s2 ="abc";
        s1="hello";
        System.out.println(s1 == s2);  //比较s1和s2的地址值
        System.out.println(s1); //hello
        System.out.println(s2); //abc
        System.out.println("****************");
        String s3="abc";
        s3+="def";
        System.out.println(s3); //abcdef
        System.out.println(s2);
        System.out.println("***************");
        String s4="abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4); //abc
        System.out.println(s5); //mbc
    }

    /**
     * String的实例化方式：
     * 方式一 ：通过字面量定义的方式
     * 方式二 ：通过new+构造器的方式
     *
     * 面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
     *       两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据
     *
     */
    @Test
    public void test2(){
        //此时通过字面量定义的方式，此时的s1和s2的数据声明在方法区中的字符串常量池
        String s1 = "java";
        String s2 = "java";
        //通过new+构造器的方式：此时s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaee");
        String s4 = new String("javaee");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false
    }

    /**
     * 结论：
     * 1.常量与常量的拼接结果在常量池中。且常量池中不会存在相同内容的容量
     * 2.只要其中有一个是变量，结果就在堆中
     * 3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = "hadoop";
        System.out.println(s1 == s3); //false

        final String s4 = "javaEE"; // s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5); // true

    }

    @Test
    public void test3(){
        String s1 = "javaee";
        String s2 = "hadoop";

        String s3 = "javaeehadoop";   //字面量的连接  在常量池中
        String s4 = "javaee"+"hadoop";  //字面量的连接  在常量池中
        String s5 = s1+"hadoop";  //有变量名参与，在堆空间(相当于new)
        String s6 = "javaee"+s2;  //有变量名参与，在堆空间(相当于new)
        String s7 = s1+s2;        //有变量名参与，在堆空间(相当于new)

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s5 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s5 == s7); //false

        String s8 = s5.intern();  //返回值得到的s8的常量池中已经存在的"javaeehadoop"
        System.out.println(s3 == s8); //true


    }
}
