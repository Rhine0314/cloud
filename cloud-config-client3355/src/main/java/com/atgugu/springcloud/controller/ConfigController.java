package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //加这个注解实现刷新配置中心的参数功能，运维要发一个post请求后才能刷新
public class ConfigController {
    @Value("${car.honda}")
    private String car;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config/getValueByKey")
    public String getConfig(){
        return "客户端端口:" + port + ",配置值为:" + car;
    }
}
