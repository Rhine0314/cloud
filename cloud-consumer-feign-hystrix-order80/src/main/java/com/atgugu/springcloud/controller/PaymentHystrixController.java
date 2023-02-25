package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/consumer")
//启用DefaultProperties，指定降级方法，下面接口如果有注解但是没有绑定方法的，会统一使用指定的方法做服务降级
@DefaultProperties(defaultFallback = "paymentInfo_default_handler")
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @HystrixCommand
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
//        int i = 1/0; //模拟异常，会执行全局的降级方法
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_Timeout(@PathVariable("id") int id) throws InterruptedException {
        return paymentHystrixService.paymentInfo_Timeout(id);
    }
    public String paymentInfo_handler(@PathVariable("id") int id) {
        return "已经过了1.5s了，我是消费者，我不等了";
    }

    public String paymentInfo_default_handler() {
        return "这是全局的降级方法";
    }
}
