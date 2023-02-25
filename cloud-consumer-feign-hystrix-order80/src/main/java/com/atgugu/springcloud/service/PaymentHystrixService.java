package com.atgugu.springcloud.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    //模拟响应快的业务
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") int id);

    //模拟响应极慢的业务
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") int id) throws InterruptedException;
}
