package com.harry.springboot.springbootstarttest.controller;

import com.harry.springboot.helloservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {
    @Autowired
    HelloService helloservice;

    @GetMapping("/hello")
    public String hello() {
        String result = helloservice.sayHell("haha-");
        return result;
    }
}
