package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: ConfigClientApplication
 * @Author: codeZhang
 * @DateTime: 2021/2/2 11:02
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class,args);
  }
}
