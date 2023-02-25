package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.entities.CommonResult;
import com.atgugu.springcloud.entities.Payment;
import com.atgugu.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) { //这个RequestBody非常重要，不加的话服务端自测是没问题的，但是消费端调用就会null
        int result = paymentService.create(payment);

        log.info("---payment插入结果" + result);

        if(result > 0) {
            return new CommonResult(200,"插入成功,端口号是:" + serverPort, result);
        } else {
            return new CommonResult(500,"插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectPaymentById(id);

        log.info("---payment查询结果" + payment);

        if(null != payment) {
            return new CommonResult<>(200,"查询成功,端口号是:" + serverPort, payment);
        } else {
            return new CommonResult<>(500,"查询" + id +"失败");
        }
    }

    //对外展示服务发现
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名:"+ service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("该服务对应的实例信息:" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return discoveryClient;
    }

    //模拟长业务的接口，用来测试openFeign的超时控制
    @GetMapping("/timeout")
    public String testTimeout() throws InterruptedException {
//        Thread.sleep(3000);
        return serverPort;
    }

    //sleuth + zipkin 模拟接口
    @GetMapping("/testSleuth")
    public String testSleuth() {
        return "我在测试sleuth+zipkin";
    }
}
