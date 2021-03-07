package com.itz.cloud.aop;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:09
 */
public class MyCalculatorImpl implements MyCalculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
