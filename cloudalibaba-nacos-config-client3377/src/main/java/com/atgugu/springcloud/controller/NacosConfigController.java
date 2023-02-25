package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController {
    @Value("${info.config}")
    private String config;

    @GetMapping("/nacos/config")
    public String getConfigValueByKey(){
        return "value为: " + config;
    }
}
