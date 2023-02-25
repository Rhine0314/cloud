package com.atgugu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(int id) {
        return "查询接口有问题";
    }

    @Override
    public String paymentInfo_Timeout(int id) throws InterruptedException {
        return "该接口有问题";
    }
}
