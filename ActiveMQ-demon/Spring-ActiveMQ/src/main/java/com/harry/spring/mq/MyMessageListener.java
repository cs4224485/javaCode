package com.harry.spring.mq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (null != message && message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println(text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
