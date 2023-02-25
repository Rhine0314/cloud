package com.atgugu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atgugu.springcloud.service.SentinelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SentinelOrderController {


    public static final  String PAYMENT_URL = "http://cloud-sentinel-payment";

    @Autowired
    private RestTemplate restTemplate;

//    方式1: LoadBalanced + RestTemplate调用
    @GetMapping("/consumer/getValueByKey/{id}")
    @SentinelResource(value = "fallback", fallback = "deal_fallback", blockHandler = "deal_blockHandler")
    public String exec(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+ "/getValueByKey/" + id,String.class);
    }

    public String deal_fallback(int id, Throwable e){
        return "进入了fallback兜底方法，id: " + id + "。异常信息为: " + e.getMessage();
    }

    public String deal_blockHandler(int id, BlockException e){
        return "进入了blockHandler Sentinel配置规则方法，id: " + id + "。异常信息为: " + e.getMessage();
    }

//    方式2： openfeign调用
    @Resource
    private SentinelOrderService sentinelOrderService;

    @GetMapping("/consumer/feign/getValueByKey/{id}")
//    @SentinelResource(value = "fallback", fallback = "deal_fallback", blockHandler = "deal_blockHandler")
    public String exec1(@PathVariable("id") int id){
        return sentinelOrderService.exec1(id);
    }
}
