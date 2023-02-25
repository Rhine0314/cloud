package com.atgugu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("cloud-nacos-payment")
public interface OderNacosService {

    @GetMapping("/payment/nacos/feign/{id}")
    String feignExec(@PathVariable("id") int id);
}
