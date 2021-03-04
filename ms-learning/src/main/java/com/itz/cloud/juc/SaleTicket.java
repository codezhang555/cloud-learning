package com.itz.cloud.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个售票员，卖出30张票
 * 多线程编程的企业级套路+模板
 *
 * 1.在高内聚低耦合的前提下，线程    操作(对外暴露的调用方法)   资源类
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/14 21:33
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        //lambda表达式
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.saleTicket(); },"A").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.saleTicket(); },"B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.saleTicket(); },"C").start();


        //匿名内部类,常规写法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <=40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <=40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <=40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"C").start();
    }
}

class Ticket{  //资源类
    private int number = 80;
    private int sale_number = 1;

    private Lock lock = new ReentrantLock();

    public void saleTicket(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+ (sale_number++)+"张票，"+"\t还剩下:"+--number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
