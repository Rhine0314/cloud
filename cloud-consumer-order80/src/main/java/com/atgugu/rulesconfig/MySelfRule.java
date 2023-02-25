package com.atgugu.rulesconfig;

import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

//    @Bean
//    public ReactorLoadBalancer reactorLoadBalancer(){
//        return new RoundRobinLoadBalancer();
//    }
}
