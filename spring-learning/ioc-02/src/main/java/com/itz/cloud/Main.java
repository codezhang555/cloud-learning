package com.itz.cloud;

import com.itz.cloud.cmd.ShowCmd;
import com.itz.cloud.config.JavaConfig;
import com.itz.cloud.config.JavaConfig2;
import com.itz.cloud.data.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 条件注解
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/6 23:52
 */
public class Main {
    public static void main(String[] args) {
        //m1();
        //m2();
        //m3();
        m4();
    }

    private static void m4() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
        DataSource prods = ctx.getBean("prods", DataSource.class);
        System.out.println("prods = " + prods);
    }

    /**
     * xml自动扫描配置
     */
    private static void m3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
        DataSource bean = ctx.getBean(DataSource.class);
        System.out.println("bean = " + bean);
    }

    /**
     * java代码配置
     */
    private static void m2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println("ds = " + ds);
    }

    /**
     * 条件注解
     */
    private static void m1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        String show = cmd.show();
        System.out.println("show = " + show);
    }
}
