package com.atgugu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentNacosController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/{id}")
    public String exec(@PathVariable("id") int id){
        return "Nacos registration: port [" + port + "]; id [" + id + "]";
    }

    @GetMapping("/payment/nacos/feign/{id}")
    public String feignExec(@PathVariable("id") int id){
        return "open Feign: Nacos registration: port [" + port + "]; id [" + id + "]";
    }
}
