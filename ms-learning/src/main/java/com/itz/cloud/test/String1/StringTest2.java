package com.itz.cloud.test.String1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 *
 * @author CodeZhang
 * @date 2020/5/1 13:17
 */
public class StringTest2 {

    /**
     * String与基本数据类型、包装类之间的转换
     * String --> 基本数据类型、包装类,调用包装类的静态方法。parseXXX(str)
     *
     * 基本数据类型、包装类 -->String：调用String重载的valueOf(xxx)
     */

    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num+"";

    }

    /**
     * String与字符数组char[] 之间的转换
     *
     * String --> char[] ：调用String的toCharArray()
     * char[] --> String : 调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /**
     * String 与 byte[]之间的转换
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     *
     * 编码：字符串 --> 字节 （看不懂 ---> 看不懂的二进制数据）
     * 解码：解码的逆过程：字节 -->字符串 （看不懂的二进制数据 ---> 看不懂 ）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会导致乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123";
        byte[] bytes = str1.getBytes();  //使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));

        String str2 = new String(bytes);
        System.out.println(str2);

        String str3 = new String(bytes1);
        System.out.println(str3);   //编码集与解码集不一致，导致乱码

        String gbk = new String(bytes, "gbk");
        System.out.println(gbk);
    }
}
