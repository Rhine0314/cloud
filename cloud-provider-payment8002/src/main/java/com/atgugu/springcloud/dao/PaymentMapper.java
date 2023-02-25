package com.atgugu.springcloud.dao;

import com.atgugu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment selectPaymentById(@Param("id") Long id);
}
