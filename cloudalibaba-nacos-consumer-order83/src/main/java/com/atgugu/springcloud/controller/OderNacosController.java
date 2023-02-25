package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.service.OderNacosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OderNacosController {
    @Value("${com.atgugu.springcloud.service-url.nacos-user-com.atgugu.springcloud.service}")
    public String PAYMENT_URL;

    @Autowired
    private RestTemplate restTemplate;

//    接口调用方式1： restTemplate + loadbalanced
    @GetMapping("/consumer/payment/nacos/{id}")
    public String exec(@PathVariable("id") int id){
//        alibaba写法
//        ServiceInstance serviceInstance = loadBalancerClient.choose(PAYMENT_URL);
//        String path = String.format("http://%s:%s/payment/nacos/%s",serviceInstance.getHost(),serviceInstance.getPort(),id);
//        return restTemplate.getForObject(path,String.class);

        return restTemplate.getForObject(PAYMENT_URL+ "/payment/nacos/" + id,String.class);
    }

    @Autowired
    OderNacosService oderNacosService;
    //    接口调用方式2: openfeign
    @GetMapping("/consumer/payment/nacos/feign/{id}")
    public String feignExec(@PathVariable("id") int id){
        return oderNacosService.feignExec(id);
    }
}