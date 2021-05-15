package com.harry.springcloud.controller;

import com.harry.springcloud.entities.CommonResult;
import com.harry.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback="paymentTimeOutFallbackMethod")
public class PaymentController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    /**
     * 超时访问全局fallback
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/global/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut_Global(@PathVariable("id") Integer id) {
        int age =10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    @GetMapping(value = "/payment/get/{id}")
    public String getPaymentById(@PathVariable("id") Integer id) {
        return  paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/hystrix/timeout/{id}")
    public String paymentFeignTimeout(@PathVariable("id") Integer id) {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }
}
