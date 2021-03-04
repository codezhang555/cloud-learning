package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: ConfigSecurityServerApplication
 * @Author: codeZhang
 * @DateTime: 2021/2/2 11:26
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigSecurityServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigSecurityServerApplication.class,args);
  }
}
