package com.atgugu.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;

public interface MessageOutService {

    String sendMsg();
}
