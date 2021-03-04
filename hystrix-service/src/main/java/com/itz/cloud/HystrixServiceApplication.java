package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: HystrixServiceApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/28 13:41
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启Hystrix断路器功能
public class HystrixServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(HystrixServiceApplication.class,args);
  }
}
