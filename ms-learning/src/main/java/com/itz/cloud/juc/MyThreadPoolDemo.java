package com.itz.cloud.juc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的7个参数：
 *    int corePoolSize   线程池的常驻核心线程数
 *    int maximumPoolSize   同时容纳的最大线程数，此值必须大于等于1
 *    long keepAliveTime   多余的空闲线程的存活时间，当前池中线程数量超过coolPoolSize时，当空闲时间达到keepAliveTime时，多余线程会被销毁知道只剩下corePoolSize个线程为止
 *    TimeUnit unit   keepAliveTime的单位
 *    BlockingQueue<Runnable> workQueue   任务队列，被提交但尚未执行的任务
 *    ThreadFactory threadFactory   表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
 *    RejectedExecutionHandler handler   拒绝策略，表示当队列满了，并且工作线程大于等于线程池的最大线程数(maximumPoolSize)时如何来拒绝请求执行的runnable的策略
 *
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.juc
 * @Version 1.0
 * @date 2020/12/20 22:17
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService pool = Executors.newFixedThreadPool(5);//一池5个受理线程，类似一个银行有5个受理窗口
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        ExecutorService pool = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t受理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

    }
}
