package com.itz.cloud.test.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户，两个储户分别向同一个账户存3000元，每次存1000.存3次。每次存完打印账户余额
 *
 * 分析：
 *  1.是否是多线程问题？ 是，有两个储户线程
 *  2.是否有共享数据？ 有，账户（或账户余额）
 *  3.是否有线程安全问题？ 有
 *  4.是否需要解决线程安全问题？ 同步机制：有三种方式
 *
 * @author CodeZhang
 * @date 2020/4/29 15:43
 */
class Account{
    private double balance;

    private static  ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt){
        try {
            lock.lock();

            if (amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
            }
        }finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread{

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);

        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("储户1");
        c2.setName("储户2");

        c1.start();
        c2.start();
    }
}
