package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    //引入consul注册中心后，这个就不能写死了，需要改成注册中心暴露的applicationName
    private static final String PAYMENT_URL = "http://cloud-payment-consul-service";

    @Autowired
    private RestTemplate restTemplate;

    //http://localhost/consumer/payment/consul
    @GetMapping("/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
