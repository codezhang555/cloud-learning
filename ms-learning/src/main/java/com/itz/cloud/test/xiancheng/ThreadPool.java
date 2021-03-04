package com.itz.cloud.test.xiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式4：使用线程池
 *
 * 好处：
 * 1.提供相应速度(减少了创建新线程的时间)
 * 2.降低资源消耗(重复利用线程池中线程，不需要每次都创建)
 * 3.便于线程管理
 *
 * 线程池的重要参数：
 *    1.corePoolSize：核心线程数
 *    2.queueCapacity：任务队列容量（阻塞队列）
 *    3.maximumPoolSize：最大线程数
 *    4.keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *    5.allowCoreThreadTimeout：允许核心线程超时
 *    6.rejectedExecutionHandler：任务拒绝处理器
 *
 * 面试题：创建多线程有几种方式？  四种
 *
 * @author CodeZhang
 * @date 2020/4/30 14:55
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //设置线程池的属性
        System.out.println(service.getClass());


        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合使用于Runnable
        service.execute(new NumberThread1());
//        service.submit(Callable callable);//适合使用于Callable

        service.shutdown(); //3.关闭连接池
    }
}
