package com.atgugu.springcloud.service;

import com.atgugu.springcloud.entities.Payment;

public interface PaymentService{

    int create(Payment payment);

    Payment selectPaymentById(Long id);
}
