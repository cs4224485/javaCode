package com.harry.spring.mq;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class SpringMQ_Produce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_Produce springMQProduce = (SpringMQ_Produce) applicationContext.getBean(SpringMQ_Produce.class);
        springMQProduce.jmsTemplate.send((session -> {
            return session.createTextMessage("***Spring和ActiveMQ的整合case111.....");
        }));
        System.out.println("********send task over");
    }
}
