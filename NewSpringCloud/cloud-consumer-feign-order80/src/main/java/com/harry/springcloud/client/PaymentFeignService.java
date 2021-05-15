package com.harry.springcloud.client;

import com.harry.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "cloud-payment-service")
@Component
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);
    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

}
