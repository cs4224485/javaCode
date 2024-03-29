package com.harry.spring.cloud.service;

import com.harry.springcloud.entities.CommonResult;
import com.harry.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long  id);
}
