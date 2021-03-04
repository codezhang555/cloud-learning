package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: HystrixDashboardApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/28 17:22
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard  //启用监控功能
public class HystrixDashboardApplication {
  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardApplication.class,args);
  }
}
