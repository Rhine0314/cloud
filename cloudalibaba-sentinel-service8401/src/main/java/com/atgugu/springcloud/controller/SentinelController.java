package com.atgugu.springcloud.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
public class SentinelController {
    @GetMapping("/sentinel/getA")
    public String getA() {
        return "I am AAAAAAA";
    }

    @GetMapping("/sentinel/getB")
    public String getB() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am BBBBBBB";
    }


    //测试热点Key规则
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(
                             @RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2
                            )
    {
        return "正常进入了...p = " + p1 + ".." + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException) {
        return "进入了热点key的降级方法";
    }

}
