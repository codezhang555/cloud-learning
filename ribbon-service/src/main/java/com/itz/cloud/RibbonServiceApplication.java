package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: RibbonServiceApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/28 11:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(RibbonServiceApplication.class,args);
  }
}
