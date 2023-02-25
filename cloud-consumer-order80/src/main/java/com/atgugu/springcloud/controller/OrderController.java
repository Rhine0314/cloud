package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.entities.CommonResult;
import com.atgugu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    //引入eureka注册中心后，这个就不能写死了，需要改成注册中心暴露的applicationName
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //不建议直接在字段中使用autowired
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    //测试sleuth+zipkin
    @GetMapping("/payment/testSleuth")
    public String testSleuth() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/testSleuth", String.class);
    }
}