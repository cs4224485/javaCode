package com.harry.activemq.mq;

import com.harry.activemq.bean.MessageModel;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DelayConsumer {
    @JmsListener(destination = "delay.queue")
    public void receiveQueue(MessageModel message) throws InterruptedException {
        Thread.currentThread().sleep(10000L);
        System.out.println("收到消息:"+message);
    }
}
