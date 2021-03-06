package com.itz.cloud.config;

import com.itz.cloud.cmd.*;
import com.itz.cloud.data.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/6 23:50
 */
@Configuration
public class JavaConfig {
    @Bean("cmd")
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd(){
        return new WindowsShowCmd();
    }

    @Bean("cmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd(){
        return new LinuxShowCmd();
    }

    @Bean
    @Profile("dev")
    DataSource devDs(){
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://localhost/vhr");
        ds.setUsername("root");
        ds.setPassword("123");
        return ds;
    }

    @Bean
    @Profile("prod")
    DataSource prodDs(){
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://192.168.0.1/vhr");
        ds.setUsername("root");
        ds.setPassword("123");
        return ds;
    }
}
