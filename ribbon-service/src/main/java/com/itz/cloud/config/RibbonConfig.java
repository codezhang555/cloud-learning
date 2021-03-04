package com.itz.cloud.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName: com.itz.cloud.config
 * @ClassName: RibbonConfig
 * @Author: codeZhang
 * @DateTime: 2021/1/28 11:18
 * @Version 1.0
 */
@Configuration
public class RibbonConfig {

  /**
   * Ribbon的负载均衡策略
   * 所谓的负载均衡策略，就是当A服务调用B服务时，此时B服务有多个实例，这时A服务以何种方式来选择调用的B实例，
   * ribbon可以选择以下几种负载均衡策略。
   *
   * 1.com.netflix.loadbalancer.RandomRule：从提供服务的实例中以随机的方式；
   *
   * 2.com.netflix.loadbalancer.RoundRobinRule：以线性轮询的方式，就是维护一个计数器，从提供服务的实例中按顺序选取，第一次选第一个，第二次选第二个，以此类推，到最后一个以后再从头来过；
   *
   * 3.com.netflix.loadbalancer.RetryRule：在RoundRobinRule的基础上添加重试机制，即在指定的重试时间内，反复使用线性轮询策略来选择可用实例；
   *
   * 4.com.netflix.loadbalancer.WeightedResponseTimeRule：对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择；
   *
   * 5.com.netflix.loadbalancer.BestAvailableRule：选择并发较小的实例；
   *
   * 6.com.netflix.loadbalancer.AvailabilityFilteringRule：先过滤掉故障实例，再选择并发较小的实例；
   *
   * 7.com.netflix.loadbalancer.ZoneAwareLoadBalancer：采用双重过滤，同时过滤不是同一区域的实例和故障实例，选择并发较小的实例。
   * @return
   */

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
