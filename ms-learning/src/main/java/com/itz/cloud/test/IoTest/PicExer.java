package com.itz.cloud.test.IoTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片加密
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.test.IoTest
 * @Version 1.0
 * @date 2020/11/28 16:42
 */
public class PicExer {

    /**
     * 图片加密
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("t2.jpg");
        FileOutputStream fos = new FileOutputStream("t5.jpg");
        byte[] bytes = new byte[20];
        int len;
        while ((len = fis.read(bytes)) != -1){
            //字节数组进行修改
            //错误的
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            fos.write(bytes,0,len);
        }
        System.out.println("复制成功");
        fis.close();
        fos.close();
    }

    /**
     * 图片解密
     */
    @Test
    public void test2() throws IOException {
        FileInputStream fis = new FileInputStream("t5.jpg");
        FileOutputStream fos = new FileOutputStream("t6.jpg");
        byte[] bytes = new byte[20];
        int len;
        while ((len = fis.read(bytes)) != -1){
            //字节数组进行修改
            //错误的
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            fos.write(bytes,0,len);
        }
        System.out.println("复制成功");
        fis.close();
        fos.close();
    }
}
