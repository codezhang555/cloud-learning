package com.itz.cloud.test.IoTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 *  1.对于文本文件（.txt,.java,.c,.cpp），使用字符流处理
 *  2.对于非文本文件(图片，音频，视频,.ppt,.doc)，使用字节流处理
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.test.IoTest
 * @Version 1.0
 * @date 2020/11/28 15:47
 */
public class FileInputOutputStream {


    /**
     * 处理文本文件出现乱码
     * @throws IOException
     */
    @Test
    public void testFileInputStream() throws IOException {
        //1.造文件
        File file = new File("hello.txt");
        //2.造流
        FileInputStream fileInputStream = new FileInputStream(file);
        //3.读数据
        byte[] bytes = new byte[5];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            String str = new String(bytes, 0, len);
            System.out.print(str);
        }
        //4.关闭资源
        fileInputStream.close();
    }

    /**
     * 实现对图片的复制
     */
    @Test
    public void testImg(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File("t2.jpg");
            File desFile = new File("t3.jpg");

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);

            byte[] bytes = new byte[5];
            int len;
            while ((len=fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream){
                    fileInputStream.close();
                }
                if (null != fileOutputStream){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定路径下文件的复制
     */
    public void copyFile(String srcPath,String decPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File(srcPath);
            File desFile = new File(decPath);

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);

            byte[] bytes = new byte[512];
            int len;
            while ((len=fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream){
                    fileInputStream.close();
                }
                if (null != fileOutputStream){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\72991\\Desktop\\test\\01-springboot.mp4";
        String desPath = "C:\\Users\\72991\\Desktop\\test\\02-springboot.mp4";
        copyFile(srcPath,desPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作的花费时间为:"+(end-start));
    }
}
