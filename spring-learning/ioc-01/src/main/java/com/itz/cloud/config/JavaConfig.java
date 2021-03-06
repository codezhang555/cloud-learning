package com.itz.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.config
 * @Version 1.0
 * @date 2021/3/6 23:17
 *
 * java配置
 * configuration注解表示这是一个java配置类，配置类的作用类似于applicationContext.xml
 */
@Configuration
@ComponentScan(basePackages = "com.itz.cloud",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Repository.class)})
public class JavaConfig {

    @Bean("sh")
    SayHello sayHello(){
        return new SayHello();
    }
}
