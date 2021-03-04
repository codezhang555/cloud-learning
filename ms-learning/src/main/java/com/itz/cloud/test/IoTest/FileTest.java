package com.itz.cloud.test.IoTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录(文件夹)
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *   并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 *
 * @author CodeZhang
 * @date 2020/5/5 14:21
 */
public class FileTest {
    /**
     * 1.如何创建File类的实例
     *   File(String filePath)
     *   File(String parentPath,String childPath)
     *   File(File parentFile,String childPath)
     *
     * 2.相对路径: 相较于某个路径下，指明的路径
     *   绝对路径: 包含盘符在内的文件或文件目录的路径
     *
     * 3.路径分隔符
     *  window:\\
     *  unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File file = new File("hello.txt"); //相对于当前module

    }

    /**
     * File类常用方法：
     *
     * ●File类的获取功能
     * public String getAbsolutePath():获取绝对路径
     * public String getPath():获取路径
     * public String getName():获取名称
     * public String getParent():获取上层文件目录路径。若无，返回null
     * public long length(:获取文件长度(即:字节数)。不能获取目录的长度。
     * public long lastModified():获取最后- - 次的修改时间，毫秒值
     * public String[] list(): 获取指定目录下的所有文件或者文件目录的名称数组
     * public File listFiles():获取指定目录下的所有文件或者文件目录的File数组
     *
     * ●File类的重命名功能
     * public boolean renameTo(File dest):把文件重命名为指定的文件路径
     *  比如：File1.renameTo(File2)为例
     *
     *
     * File类的判断功能
     * public boolean isDirectory(): 判断是否是文件目录   不是文件目录就是文件
     * public boolean isFile() :判断是否是文件
     * public boolean exists() :判断是否存在
     * public boolean canRead() :判断是否可读
     * public boolean canWrite() :判断是否可写
     * public boolean isHidden() :判断是否隐藏
     *
     *
     */
    @Test
    public void test02(){
        File file = new File("hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }


    /**
     * * 创建硬盘中对应的文件会文件目录
     *      public boolean createNewFile() ;创建文件。若文件存在，则不创建，返回false
     *      public boolean mkdir() :创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层不存在，则不创建
     *      public boolean mkdirs() :创建文件目录。如果上层文件目录不存在，一并创建
     *
     *      删除硬盘中的文件会文件目录
     *      public boolean delete(): 删除文件或者文件夹
     *      删除注意事项：
     *      Java中的删除不走回收站
     */

    @Test
    public void test03() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
        }else{
            file.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test04(){

    }

}
