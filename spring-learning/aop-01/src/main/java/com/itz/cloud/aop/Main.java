package com.itz.cloud.aop;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:13
 */
public class Main {
    public static void main(String[] args) {
        MyCalculatorImpl myCalculator = new MyCalculatorImpl();
        MyCalculator instance = (MyCalculator) CalculatorProxy.getInstance(myCalculator);
        int add = instance.add(3,5);
        System.out.println("add = " + add);
    }
}
