package com.harry.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        // Spring启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
