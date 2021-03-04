package com.itz.cloud.test.xiancheng;

/**
 * 创建多线程的方式二：实现runnable接口
 * 1.创建一个实现了runnable接口的类
 * 2.实现类去实现runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start():1.启动线程 2.调用当前线程的run()-->调用了runnable类型的target的run()
 *
 *
 * 比较创建线程的两种方式：
 * 优先选择实现runnable接口的方式
 * 原因：1.实现的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况
 * 联系：public class Thread implements Runnable
 * 相同点：都需要重写run()方法，将线程要执行的逻辑声明在run()方法中
 *
 * @author CodeZhang
 * @date 2020/4/28 15:59
 */

//1.创建一个实现了runnable接口的类
class MThread implements Runnable{
    //2.实现类去实现runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread m1 = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        //5.通过Thread类的对象调用start():1.启动线程 2.调用当前线程的run()-->调用了runnable类型的target的run()
        t1.start();

        //再启动一个线程
        Thread t2 = new Thread(m1);
        t2.start();
    }
}
