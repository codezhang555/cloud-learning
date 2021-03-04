package com.itz.cloud.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/20 15:22
 *
 * 多线程，第3种获得多线程的方式
 *
 *
 * 面试题：callable接口与runnable的区别
 *    1.是否有返回值
 *    2.是否抛异常
 *    3.落地方法不一样，一个是run,一个是call
 *
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask task = new FutureTask(new MyThread());
        new Thread(task,"A").start();
        new Thread(task,"B").start();
        System.out.println(Thread.currentThread().getName()+"****计算完成");
        System.out.println(task.get());
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*******************come in");
        TimeUnit.SECONDS.sleep(4);
        return 1024;
    }
}
