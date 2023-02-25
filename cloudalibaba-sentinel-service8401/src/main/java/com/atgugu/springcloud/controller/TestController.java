package com.atgugu.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    @SentinelResource(value = "test", blockHandler = "deal_test")
    public String getA() {
        return "I am test";
    }

    public String deal_test(BlockException blockException) {
        return "这是兜底方法";
    }
}
