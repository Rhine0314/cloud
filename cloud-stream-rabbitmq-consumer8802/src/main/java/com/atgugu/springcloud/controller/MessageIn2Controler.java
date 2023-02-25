package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

//@EnableBinding(Sink.class)
public class MessageIn2Controler {
//    @Value("${server.port}")
//    private String port;
//
//    @StreamListener(Sink.INPUT)
//    public void input(Message<String> message){
//        System.out.println("我是第二个。" + port + "端口收到的消息为：" + message.getPayload());
//    }
}
