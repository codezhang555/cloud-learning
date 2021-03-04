package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @PackageName: com.itz.cloud
 * @ClassName: EurekaClientApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/28 10:31
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class,args);
  }
}
