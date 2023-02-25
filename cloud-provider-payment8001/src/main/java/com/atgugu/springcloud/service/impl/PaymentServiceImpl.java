package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.dao.PaymentMapper;
import com.atgugu.springcloud.entities.Payment;
import com.atgugu.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentMapper.selectPaymentById(id);
    }
}
