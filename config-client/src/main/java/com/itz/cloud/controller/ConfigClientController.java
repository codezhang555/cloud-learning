package com.itz.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.itz.cloud.controller
 * @ClassName: ConfigClientController
 * @Author: codeZhang
 * @DateTime: 2021/2/2 11:05
 * @Version 1.0
 */
@RestController
@RefreshScope  //刷新配置
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/configInfo")
  public String getConfigInfo(){
    return configInfo;
  }
}
