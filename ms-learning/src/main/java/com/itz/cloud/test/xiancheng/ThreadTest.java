package com.itz.cloud.test.xiancheng;

/**
 * 多线程的创建，方式一：继承于Thread类
 *  1.创建一个继承于Thread类的子类
 *  2.重写Thread类的run()方法 --> 将线程执行的操作声明在run()方法中
 *  3.创建Thread类的子类的对象
 *  4.通过此对象去调用start()方法
 *
 *  例：遍历100以内所有的偶数
 *
 * @author CodeZhang
 * @date 2020/4/28 14:14
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        /**
         * 4.通过此对象去调用start()方法
         *    start()方法作用：
         *        1.启动当前线程
         *        2.调用当前线程的run()方法
         */
        t1.start();
        //问题一：不能直接调用run()方法启动线程
        //问题二：再启动一个线程，不可以还让已经start()的线程去执行，会报错，新建一个线程再执行
        //t1.run();

        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100 ; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+i+"****************");
            }
        }
    }

}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()方法 --> 将线程执行的操作声明在run()方法中
    @Override
    public void run(){
        for (int i = 0; i < 100 ; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }

    }

}