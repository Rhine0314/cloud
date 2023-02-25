package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.entities.CommonResult;
import com.atgugu.springcloud.entities.Payment;
import com.atgugu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.selectPaymentById(id);
    }

    @GetMapping("/payment/timeout")
    public String testTimeout() throws Exception {
        return paymentFeignService.testTimeout();
    }
}
