package com.atgugu.springcloud.service;

import com.atgugu.springcloud.dao.OrderMapper;
import com.atgugu.springcloud.entity.CommonResult;
import com.atgugu.springcloud.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface OrderService {
    //创建订单
    CommonResult createOrder(Order order);
}
