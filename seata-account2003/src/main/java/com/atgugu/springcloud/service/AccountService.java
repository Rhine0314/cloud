package com.atgugu.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {

    int decreaseAccount(Long userId, BigDecimal money);
}
