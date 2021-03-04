package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PackageName: com.itz.cloud
 * @ClassName: EurekaSecurityServerApplication
 * @Author: codeZhang
 * @DateTime: 2021/1/28 10:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSecurityServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaSecurityServerApplication.class,args);
  }
}
