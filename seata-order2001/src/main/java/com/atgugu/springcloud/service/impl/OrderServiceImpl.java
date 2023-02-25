package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.dao.OrderMapper;
import com.atgugu.springcloud.entity.CommonResult;
import com.atgugu.springcloud.entity.Order;
import com.atgugu.springcloud.service.AccountService;
import com.atgugu.springcloud.service.OrderService;
import com.atgugu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    public CommonResult createOrder(Order order) {
        //第一步新建订单
        orderMapper.createOrder(order);

        //第二步扣减库存
        storageService.decreaseStorage(order.getProductId(), order.getCount());

        //第三步扣减金额
        accountService.decreaseAccount(order.getUserId(), order.getMoney());

        //第四步将订单置为成功状态，业务结束
        orderMapper.updateOrderStatus(order.getUserId(), order.getProductId(), 0);

        return new CommonResult(200,"下订单成功");
    }

}
