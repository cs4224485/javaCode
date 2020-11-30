package com.harry.activemq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Queue_consumer {
    // 注册一个监听器。destination指定监听的队列
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("*** 消费者接受消息 ***"+ textMessage.getText());
    }
}
