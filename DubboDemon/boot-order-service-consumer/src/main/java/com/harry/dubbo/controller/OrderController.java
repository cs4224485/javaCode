package com.harry.dubbo.controller;

import com.harry.dubbo.bean.UserAddress;
import com.harry.dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order")
    @ResponseBody
    public    List<UserAddress> getUserAddress(@RequestParam("userId") String userId){
        List<UserAddress> userAddresses = orderService.initOrder(userId);
        return userAddresses;
    }
}
