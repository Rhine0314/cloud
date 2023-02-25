package com.atgugu.springcloud.controller;

import com.atgugu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public void decreaseAccount(@RequestParam("userId") Long userId,
                                @RequestParam("money") BigDecimal money) {
        accountService.decreaseAccount(userId, money);
    }
}
