package com.atgugu.springcloud.service;

import com.atgugu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-service")
public interface AccountService {
    //根据用户和金额，减去对应的人的钱
    @PostMapping("/account/decrease")
    void decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
