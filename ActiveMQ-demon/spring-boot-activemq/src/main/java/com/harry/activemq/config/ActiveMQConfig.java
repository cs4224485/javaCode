package com.harry.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ActiveMQConfig {
    @Bean
    public ActiveMQConnectionFactory factory(@Value("${spring.activemq.broker-url}") String url){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        // 设置信任序列化包集合
        List<String> models = new ArrayList<>();
        models.add("com.harry.activemq");
        factory.setTrustedPackages(models);

        return factory;
    }

}
