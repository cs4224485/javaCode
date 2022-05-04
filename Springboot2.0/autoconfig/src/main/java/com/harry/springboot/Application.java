package com.harry.springboot;

import com.harry.springboot.bean.Car;
import com.harry.springboot.bean.Pet;
import com.harry.springboot.bean.User;
import com.harry.springboot.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.harry.springboot")
public class Application {
    public static void main(String[] args) {
        // 1. 返回IOC容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car.getBrand());
        System.out.println(car.getPrice());
    }
}