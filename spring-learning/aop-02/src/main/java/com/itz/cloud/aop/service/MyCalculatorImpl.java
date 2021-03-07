package com.itz.cloud.aop.service;

import org.springframework.stereotype.Component;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:19
 */
@Component
public class MyCalculatorImpl implements MyCalculator {

//    @Action
    public Integer add(int a, int b) {
//        int d = 1/0;
        System.out.println(a + "+" + b + "=" + (a+b));
        return a + b;
    }


//    @Action
    public void min(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a-b));
    }
}
