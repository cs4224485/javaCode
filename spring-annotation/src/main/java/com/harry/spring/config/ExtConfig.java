package com.harry.spring.config;

import com.harry.spring.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.harry.spring")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }


}