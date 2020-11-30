package com.harry.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    // 注入配置文件中的myqueue
    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue(myQueue);
    }

}
