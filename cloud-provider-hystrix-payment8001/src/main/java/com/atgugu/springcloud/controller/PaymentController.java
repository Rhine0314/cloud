package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") int id) throws InterruptedException {
        return paymentService.paymentInfo_Timeout(id);
    }

    //================================下面是服务熔断的测试方法
    @GetMapping("/circuitbreaker/{id}")
    public String hystrix_circuit_breaker(@PathVariable("id") int id) {
        return paymentService.hystrix_circuit_breaker(id);
    }
}
