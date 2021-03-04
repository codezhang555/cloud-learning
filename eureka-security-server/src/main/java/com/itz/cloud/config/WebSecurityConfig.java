package com.itz.cloud.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @PackageName: com.itz.cloud.config
 * @ClassName: WebSecurityConfig
 * @Author: codeZhang
 * @DateTime: 2021/1/28 10:53
 * @Version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  /**
   * 默认情况下添加SpringSecurity依赖的应用每个请求都需要添加CSRF token才能访问，
   * Eureka客户端注册时并不会添加，所以需要配置/eureka/**路径不需要CSRF token。
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().ignoringAntMatchers("/eureka/**");
    super.configure(http);
  }
}
