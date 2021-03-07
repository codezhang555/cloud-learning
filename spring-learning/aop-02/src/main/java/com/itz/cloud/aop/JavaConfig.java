package com.itz.cloud.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aop
 * @Version 1.0
 * @date 2021/3/7 23:25
 */
@Configuration
@ComponentScan
//开启自动代理
@EnableAspectJAutoProxy
public class JavaConfig {
}
