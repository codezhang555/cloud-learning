package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: TurbineServiceApplication
 * @Author: codeZhang
 * @DateTime: 2021/2/1 9:37
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class TurbineServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(TurbineServiceApplication.class,args);
  }
}
