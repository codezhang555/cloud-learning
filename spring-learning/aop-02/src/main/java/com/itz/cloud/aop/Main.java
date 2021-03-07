package com.itz.cloud.aop;

import com.itz.cloud.aop.service.MyCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:25
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        MyCalculator calculator = ctx.getBean(MyCalculator.class);
        calculator.add(3,4);
        calculator.min(2,4);
    }
}
