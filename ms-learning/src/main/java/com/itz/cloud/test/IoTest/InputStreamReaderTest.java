package com.itz.cloud.test.IoTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二： 转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamReader：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.  解码：字节、字节数组 ----> 字符数组、字符串
 * 编码：字节、字节数组 <---- 字符数组、字符串
 *
 * 4.字符集
 *
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.test.IoTest
 * @Version 1.0
 * @date 2020/11/28 16:57
 */
public class InputStreamReaderTest {

    /**
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis);  //使用系统默认的字符集
        //参数2指明了字符集
        InputStreamReader isr2 = new InputStreamReader(fis, "UTF-8");
        char[] cbuf = new char[20];
        int len;
        while ((len = isr2.read(cbuf)) != -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        isr2.close();
    }


    @Test
    public void test2(){

    }
}
