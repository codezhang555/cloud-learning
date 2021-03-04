package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign 是声明式的服务调用工具，我们只需创建一个接口并用注解的方式来配置它，就可以实现对某个服务接口的调用，简化了直接使用 RestTemplate 来调用服务接口的开发量。
 * Feign 具备可插拔的注解支持，同时支持 Feign 注解、JAX-RS 注解及 SpringMvc 注解。当使用 Feign 时，Spring Cloud 集成了 Ribbon 和 Eureka 以提供负载均衡的服务调用及基于 Hystrix 的服务容错保护功能。
 * @PackageName: cn.itz.cloud
 * @ClassName: FeignServiceApplication
 * @Author: codeZhang
 * @DateTime: 2021/2/1 10:59
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(FeignServiceApplication.class,args);
  }
}
