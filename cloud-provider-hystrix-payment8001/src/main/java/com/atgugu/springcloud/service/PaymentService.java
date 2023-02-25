package com.atgugu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    //模拟响应快的业务
    public String paymentInfo_OK(int id) {
//        int i = 1/0; // 模拟错误，消费端用调用，会执行PaymentFallbackService这个类的降级方法
        return "线程池" + Thread.currentThread().getName() + "。   payment_ok:" + id;
    }

    //模拟响应极慢的业务
    @HystrixCommand(fallbackMethod = "paymentInfo_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(int id) throws InterruptedException {
        int time = (int) (Math.random() * 10);
        if(time > 5) time = time - 4;
        if(time == 3) {
            int c = 1/0; //故意制造报错
        }
        Thread.sleep(time * 1000L);  //只会 1 2 3 4 5秒。 1 2 3能返回，4 5就超时
        return "线程池" + Thread.currentThread().getName() + "。   payment_timeout:" + id + "。  time为:" + time;
    }

    public String paymentInfo_handler(int id) {
        return "线程池" + Thread.currentThread().getName() + "。   系统繁忙或程序有误";
    }


    //================================下面是服务熔断的测试方法
    @HystrixCommand(fallbackMethod = "hystrix_circuit_breaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String hystrix_circuit_breaker(int id) {
        //测试：比如在20s内连续执行10次方法，如果有6次或以上失败，就会进入熔断机制，这时再调就会进入降级方法中
        if (id < 0){
           throw new RuntimeException("不能为负数");
        }
        return "测试熔断:线程池" + Thread.currentThread().getName() + "。   payment_ok:" + id;
    }

    public String hystrix_circuit_breaker_fallback(int id) {
        return "测试熔断：这里是降级方法";
    }
}
