package com.harry.activemq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
@EnableJms
public class ConfigTopicBean {
    @Value("${mytopic}")
    private String  topicName ;

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }

}
