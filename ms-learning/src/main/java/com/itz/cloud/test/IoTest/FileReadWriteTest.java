package com.itz.cloud.test.IoTest;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.test.IoTest
 * @Version 1.0
 * @date 2020/11/28 13:10
 *
 *
 *
 * 流的体系结构
 * 抽象基类               节点流(或文件流)                                      缓冲流（处理流的一种）
 * InputStream           FileInputStream(read(byte[] buffer))                 BufferedInputStream(read(byte[] buffer))
 * OutputStream          FileOutputStream(write(byte[] buffer,0,len))         BufferedOutputStream(write(byte[] buffer,0,len) / flush())
 * Reader                FileReader(read(char[] cbuf))                        BufferedReader(read(char[] cbuf)/readLine())
 * Writer                FileWriter(write(char[] cbuf,0,len))                 BufferedWriter(write(char[] cbuf,0,len)  / flush())
 *
 *
 */
public class FileReadWriteTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");  //相较于当前工程
        System.out.println(file.getAbsolutePath());

    }

    @Test
    public void testFileReader(){
        //1.实例化file类对象，指明要操作的文件
        File file = new File("hello.txt");  //想较于当前module
        //2.提供具体的流
        try {
            FileReader fr = new FileReader(file);
            //3.数据的读入 read():返回读入的一个字符。如果达到文件末尾，返回-1
            int read = fr.read();
            while (read != -1){
                System.out.print((char) read);
                read = fr.read();
            }
            //4.流的关闭操作
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对read()操作升级，使用read的重载方法
     */
    @Test
    public void testFileReader1(){
        //1.File类的实例化
        File file = new File("hello.txt");
        FileReader fileReader = null;
        //2.FileReader流的实例化
        try {
            fileReader = new FileReader(file);
            //3.读入的操作 read(char[] cbuffer 返回每次读入cbuffer数组中的字符的个数，如果达到文件末尾，返回-1)
            char[] cbuffer = new char[5];
            int len;
            while( (len = fileReader.read(cbuffer)) != -1){
                //方式一：错误写法
//                for (int i = 0; i < cbuffer.length; i++) {
//                    System.out.print(cbuffer[i]);
//                }
               //方式一：正确写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuffer[i]);
//                }
                //方式二：错误写法：
//                String str = new String(cbuffer);
//                System.out.print(str);
                //方式二：正确写法
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                //4.资源关闭
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件中
     * 说明：
     *   1.输出操作对应的file可以不存在。
     *     如果不存在，在输出的过程中，会自动创建此文件
     *     如果存在， append为true 原有文件上追加
     *               append为false，原有文件覆盖
     */
    @Test
    public void testFileWriter() throws IOException {
        //1.实例化File,指定写出到的文件
        File file = new File("hello1.txt");
        //2.提供filewriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file,false);
        //3.写出数据
        fw.write("I have a dream!\n");
        fw.write("you need me");
        //4.资源的关闭
        fw.close();
    }

    @Test
    public void testFileReaderWriter() throws IOException {
        //1.创建File类对象,指明读入和写出的文件
        File srcFile = new File("hello.txt");
        File desFile = new File("hello2.png");
        //2.创建输入流和输出流的对象
        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(desFile);
        //3.数据的读入和写出操作
        char[] cbuf = new char[5];
        int len; //记录每次读入到cbuf数组中的字符的个数
        while ((len=fr.read(cbuf))!=-1){
            fw.write(cbuf,0,len);
        }
        //4.关闭流
        fr.close();
        fw.close();
    }

}
