package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.service.MessageOutService;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;
 //3.1版本被弃用，用到了这个StreamBridge这个类，可以百度
@EnableBinding(Source.class) //声明这是一个消息输出的管道
public class MessageOutServiceImpl implements MessageOutService {

    @Qualifier("output")
    @Autowired
    private MessageChannel out;

    @Override
    public String sendMsg() {
        String id = UUID.randomUUID().toString();
        System.out.println("发送的消息为:" + id);
        out.send(MessageBuilder.withPayload(id).build());
        return null;
    }
}
