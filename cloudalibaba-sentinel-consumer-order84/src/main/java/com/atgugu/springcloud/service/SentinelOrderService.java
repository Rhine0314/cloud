package com.atgugu.springcloud.service;

import com.atgugu.springcloud.service.impl.SentinelOrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-sentinel-payment", fallback = SentinelOrderServiceImpl.class)
public interface SentinelOrderService {

    @GetMapping("/getValueByKey/{id}")
    String exec1(@PathVariable("id") int id);
}

