package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SentinelPaymentController {
    @Value("${server.port}")
    private String port;

    public static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "1号选手");
        map.put(2, "2号选手");
        map.put(3, "3号选手");
    }

    @GetMapping("/getValueByKey/{id}")
    public String getValueByKey(@PathVariable("id") int id) {
        if (id == 4) {
            throw new RuntimeException("非法参数");
        } else if (null == map.get(id)) {
            throw new NullPointerException("空指针异常");
        } else {
            return "the key is:" + id + " that the value is :" + map.get(id) + "; therefore the port is " + port;
        }
    }
}
