package com.atgugu.springcloud.service;

import com.atgugu.springcloud.entities.CommonResult;
import com.atgugu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service //给当前消费者的controller注入和调用
@FeignClient("CLOUD-PAYMENT-SERVICE") //标记这是一个FeignClient，且需要调用的是哪一个服务，可以去解析接口的RequestMapper注解
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}") //这个就是服务提供者的controller暴露的接口地址
    CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String testTimeout() throws InterruptedException;
}
