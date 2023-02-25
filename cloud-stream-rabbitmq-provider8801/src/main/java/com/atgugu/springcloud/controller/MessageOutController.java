package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.service.MessageOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageOutController {

    @Autowired
    private MessageOutService messageOutService;

    @GetMapping("/sendMsg")
    public void sendMsg(){
        messageOutService.sendMsg();
    }
}
