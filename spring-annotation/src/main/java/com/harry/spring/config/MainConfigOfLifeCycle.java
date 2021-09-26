package com.harry.spring.config;

import com.harry.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.harry.spring"})
public class MainConfigOfLifeCycle {
    @Bean(initMethod="init", destroyMethod="destroy")
    public Car car() {
        return new Car();
    }
}
