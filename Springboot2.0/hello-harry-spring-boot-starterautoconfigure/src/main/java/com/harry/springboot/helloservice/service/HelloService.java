package com.harry.springboot.helloservice.service;

import com.harry.springboot.helloservice.config.HelloProperties;

public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHell(String name){
        return helloProperties.getPrefix()+"-" +name + helloProperties.getSuffix();
    }
}