package com.itz.cloud.juc;


import java.util.concurrent.TimeUnit;

/**
 * 题目：多线程8锁
 *  1.问->>>>>标准访问：先打印邮件还是短信   答：先打印mail
 *  2.问->>>>>邮件方法暂停4秒：先打印邮件还是短信   答：先打印mail
 *  3.问->>>>>新增一个普通方法：先打印邮件还是普通方法   答：先打印hello
 *  4.问->>>>>两部手机：先打印邮件还是短信   答：先打印Ms
 *  5.问->>>>>两个静态同步方法，同一步手机：先打印邮件还是短信  答：先打印Mail
 *  6.问->>>>>两个静态同步方法，两部手机：先打印邮件还是短信  答：先打印Mail
 *  7.问->>>>>一个静态同步方法，一个普通同步方法，1部手机：先打印邮件还是短信  答：
 *  8.问->>>>>一个静态同步方法，一个普通同步方法，2部手机：先打印邮件还是短信  答：
 *
 *
 *  笔记：
 *  一个对象里面如果有多个synchronized方法， 某一时刻内，只要一个线程去调用其中一个synchronized方法了，其他的线程都只能等待，换句话说，在某一个时刻内，只能有为一个
 *  一个线程去访问这些synchronized方法，锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他synchronized方法
 *
 *  加个普通方法后发现和同步锁无关
 *  换成两个对象后，不是同一把锁了，情况立刻变化
 *
 *  都换成静态同步方法后，情况又变化
 *  所有的非静态同步方法用的都是同一把锁---实例对象本身  .class这个类
 *
 *  synchronized实现同步的基础：java中的每一个对象都可以作为锁
 *  具体方法为以下3种形式
 *  对于普通同步方法，锁是当前实例对象  new
 *  对于静态同步方法，锁是当前类的class对象
 *  对于同步方法块，锁是synchronized括号里配置的对象
 *
 *  当一个线程试图访问同步代码块时，它首先必须得到锁，退出或抛出异常时必须释放锁。
 *  也就是说如果一个实例对象的普通同步方法获取锁后，该实例对象的其他普通同步方法必须等待获取锁的方法释放后才能获取锁，
 *
 *  可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，
 *  所以无需等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁
 *
 *  所有的静态同步方法用的也是同一把锁---类对象本身
 *  这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有静态条件的。
 *  但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，
 *  而不管是同一个实例对象的静态同步方法之间，
 *  还是不同的实例对象的静态同步方法之间，只要它们同一个类的实例对象！
 *
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/19 16:26
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            try {
                phone.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                phone1.sendMs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class Phone{
    public static synchronized void sendMail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("----------sendMail");
    }
    public synchronized void sendMs() throws Exception{
        System.out.println("----------sendMs");
    }

    public void hello(){
        System.out.println("----------hello");
    }
}
