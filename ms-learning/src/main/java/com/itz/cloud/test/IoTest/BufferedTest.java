package com.itz.cloud.test.IoTest;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的处理使用
 * 1.缓冲流：
 *
 * 2.作用：提供流的读取，写入的速度
 *  提高速度的原因：内存提供了一个缓冲区
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.test.IoTest
 * @Version 1.0
 * @date 2020/11/28 16:18
 */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("t2.jpg");
            File desFile = new File("t4.jpg");
            //2.造流
            //2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] bytes = new byte[5];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭  要求：先关闭外层的流，再关闭内层的流
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流自动关闭关闭内层流。关于内层流的关闭，我们可以省略。
//            fis.close();
//            fos.close();
        }
    }

    /**
     * 实现文件复制的方法
     */
    public void copyFileWithBuffered(String srcPath,String decPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File desFile = new File(decPath);
            //2.造流
            //2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
//                bos.flush();  //刷新缓冲区
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭  要求：先关闭外层的流，再关闭内层的流
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流自动关闭关闭内层流。关于内层流的关闭，我们可以省略。
//            fis.close();
//            fos.close();
        }
    }

    @Test
    public void testCopyBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\72991\\Desktop\\test\\01-springboot.mp4";
        String desPath = "C:\\Users\\72991\\Desktop\\test\\02-springboot.mp4";
        copyFileWithBuffered(srcPath,desPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作的花费时间为:"+(end-start));
    }
}
