package com.itz.cloud.test.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Jdk5.0新增
 * 创建线程的方式三：实现callable接口
 * 借助Future接口
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口的多线程方式强大？
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable接口支持泛型
 *
 * @author CodeZhang
 * @date 2020/4/30 14:12
 */
//1.创建一个实现Callable接口的实现类
class NumThread implements Callable<Integer>{
    //2.实现call方法，将此线程需要执行的操作声明在call()方法中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此callable接口实现类的对象作为参数传递到FutureTask构造器中，创造FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()启动线程
        new Thread(futureTask).start();
        try {
            //6.获取callable中的call方法的返回值
            //get()方法返回值即为FutureTask构造器参数Callback实现类重写的call()方法的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
