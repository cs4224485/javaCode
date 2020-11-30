package com.harry.activemq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Topic_consumer {
    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage){
        System.out.println("1111111111111111");
        try {
            System.out.println("消费者受到订阅的主题："+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
