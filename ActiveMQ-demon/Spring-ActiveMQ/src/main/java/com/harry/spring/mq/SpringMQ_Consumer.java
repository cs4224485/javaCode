package com.harry.spring.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_Consumer springMQConsumer = (SpringMQ_Consumer ) applicationContext.getBean("springMQ_Consumer");
        String retValue = (String) springMQConsumer.jmsTemplate.receiveAndConvert();
        System.out.println("****消费者收到的消息"+ retValue);
    }
}
