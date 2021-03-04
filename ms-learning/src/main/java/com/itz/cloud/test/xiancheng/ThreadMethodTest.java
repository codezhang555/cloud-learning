package com.itz.cloud.test.xiancheng;

/**
 * 测试Thread类中的常用方法
 * 1.start():启动当前线程；调用当前线程的run()
 * 2.run():通常重写Thread类中的此方法，将创建的线程执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回当前执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完之后，
 *          线程a才结束阻塞状态
 * 8.stop():已过时，执行此方法，强制结束当前线程
 * 9.sleep(long mills):让当前线程阻塞指定的mills毫秒，过后等cpu分配资源，不会释放锁
 * 10.isAlive():判断当前线程是否还存活
 * 11.wait():使调用该方法的线程进入阻塞状态，自动释放锁
 * 12.notify():唤醒
 *
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY = 10  最大优先级
 *   MIN_PRIORITY = 1   最小优先级
 *   NORM_PRIORITY = 5  默认优先级
 * 2.如何获取和设置当前的优先级
 *   getPriority(); 获取线程的优先级
 *   setPriority(int p); 设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上讲，高优先级的线程
 *        高概率被执行，并不意味着只有当高优先级的线程执行完以后，低优先级的线程才会执行
 *
 * @author CodeZhang
 * @date 2020/4/28 14:30
 */
class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+":"+getPriority()+":"+i);
            }

//            if (i % 20 ==0){
//                yield();
//            }
        }
    }
    public TestThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        TestThread t1 = new TestThread("Thread=1");
//        t1.setName("线程一");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(8);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }

            if (i == 20){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
