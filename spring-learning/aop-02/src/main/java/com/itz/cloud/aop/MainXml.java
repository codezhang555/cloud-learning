package com.itz.cloud.aop;

import com.itz.cloud.aop.service.MyCalculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/8 0:01
 */
public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator myCalculator = ctx.getBean(MyCalculator.class);
        myCalculator.add(5,6);
        myCalculator.min(7,1);
    }
}
