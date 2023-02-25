package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.service.SentinelOrderService;
import org.springframework.stereotype.Service;

@Service
public class SentinelOrderServiceImpl implements SentinelOrderService {

    @Override
    public String exec1(int id) {
        return "我是openfeign上的兜底方法，id为：" + id;
    }
}
