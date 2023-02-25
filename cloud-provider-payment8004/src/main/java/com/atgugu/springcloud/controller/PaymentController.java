package com.atgugu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //http://localhost:8004/payment/zk
    @GetMapping("/zk")
    public String paymentZk(){
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID();
    }
}
