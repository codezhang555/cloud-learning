package com.itz.cloud;


import com.itz.cloud.aware.AwareService;
import com.itz.cloud.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/7 23:01
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        AwareService bean = ctx.getBean(AwareService.class);
        bean.output();
    }
}
