package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.entity.CommonResult;
import com.atgugu.springcloud.entity.Order;
import com.atgugu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public CommonResult createOrder(Order order) {
        return orderService.createOrder(order);
    }
}
