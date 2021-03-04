package com.itz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API网关为微服务架构中的服务提供了统一的访问入口，客户端通过API网关访问相关服务。
 * API网关的定义类似于设计模式中的门面模式，它相当于整个微服务架构中的门面，所有客户端的访问都通过它来进行路由及过滤。
 * 它实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能。
 *
 * 路由与过滤是Zuul的两大核心功能，路由功能负责将外部请求转发到具体的服务实例上去，是实现统一访问入口的基础，过滤功能负责对请求过程进行额外的处理，
 * 是请求校验过滤及服务聚合的基础。
 * Zuul中有以下几种典型的过滤器类型。
 *   pre：在请求被路由到目标服务前执行，比如权限校验、打印日志等功能；
 *   routing：在请求被路由到目标服务时执行，这是使用Apache HttpClient或Netflix Ribbon构建和发送原始HTTP请求的地方；
 *   post：在请求被路由到目标服务后执行，比如给目标服务的响应添加头信息，收集统计数据等功能；
 *   error：请求在其他阶段发生错误时执行。
 *
 * @PackageName: com.itz.cloud
 * @ClassName: ZuulProxyApplication
 * @Author: codeZhang
 * @DateTime: 2021/2/1 13:54
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulProxyApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulProxyApplication.class,args);
  }
}
