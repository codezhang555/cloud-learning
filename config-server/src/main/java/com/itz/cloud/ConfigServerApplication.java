package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * # 获取配置信息
 * /{label}/{application}-{profile}
 * # 获取配置文件信息
 * /{label}/{application}-{profile}.yml
 *
 * 占位符相关解释
 * application：代表应用名称，默认为配置文件中的spring.application.name，如果配置了spring.cloud.config.name，则为该名称
 * label：代表分支名称，对应配置文件中的spring.cloud.config.label
 * profile：代表环境名称，对应配置文件中的spring.cloud.config.profile
 *
 * @PackageName: com.itz.cloud
 * @ClassName: ConfigServer
 * @Author: codeZhang
 * @DateTime: 2021/2/2 10:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigServerApplication.class,args);
  }
}
