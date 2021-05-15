package com.harry.spring.cloud.service;

import com.harry.springcloud.entities.CommonResult;
import com.harry.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444444, "服务降级返回", new Payment(id, "errorSerial"));
    }
}