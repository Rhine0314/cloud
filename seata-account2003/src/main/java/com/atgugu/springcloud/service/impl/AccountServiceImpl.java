package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.dao.AccountMapper;
import com.atgugu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int decreaseAccount(Long userId, BigDecimal money) {
        return accountMapper.decreaseAccount(userId, money);
    }
}
