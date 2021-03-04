package com.itz.cloud.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/20 16:13
 *
 * 达到多少数量触发
 *
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("**********召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            int temInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t收集到第:"+ temInt +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
