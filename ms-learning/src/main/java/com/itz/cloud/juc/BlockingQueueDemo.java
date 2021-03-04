package com.itz.cloud.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * 核心方法：
 *    插入:
 *    add(e)      抛出异常
 *    offer(e)    特殊值
 *    put(e)      阻塞
 *    offer(e,long,timeunit)   超时
 *    移除：
 *    remove(e)    抛出异常
 *    poll(e)       特殊值
 *    take()       阻塞
 *    poll(timeunit)   超时
 *    检查：
 *    element()    抛出异常
 *    peek()       特殊值
 *
 *    抛出异常：  当阻塞队列满时，再往队列里add插入元素会抛IllegalStateException:Queue full
 *               当阻塞队列空时，再往队列里remove移除元素会抛NoSuchElementException
 *    特殊值：   插入方法：插入成功，成功true 失败false
 *              移除方法：成功返回队列的元素，队列里没用就返回null
 *    一直阻塞： 当阻塞队列满时，生产者线程继续往队列里put元素，队列会一直阻塞生产者线程直到put数据or响应中断退出
 *              当阻塞队列空时，消费者线程试图从队列里take元素，队列会一直阻塞消费者线程直到队列可用
 *     超时退出：当阻塞队列满时，队列会阻塞生产者线程一定时间，超过限时后生产者线程会退出
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.juc
 * @Version 1.0
 * @date 2020/12/20 20:49
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.element());

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");
//
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.offer("a",3L, TimeUnit.SECONDS));
    }
}
