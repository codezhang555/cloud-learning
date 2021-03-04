package com.itz.cloud.test.exer;


/**
 * 例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 *
 * 使用同步代码块来解决继承Thread的线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器。考虑使用当前类来充当
 *      同步监视器
 *
 * @author CodeZhang
 * @date 2020/4/28 15:34
 */
class Window2 extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //正确的
//          synchronized (obj) {
            synchronized(Window2.class){ //万物皆对象，类也是对象
            //错误的 this代表着t1,t2,t3三个对象
//          synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}