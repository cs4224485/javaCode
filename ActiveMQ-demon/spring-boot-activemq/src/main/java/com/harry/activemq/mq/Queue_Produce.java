package com.harry.activemq.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
// 开启jms适配
@EnableJms
@EnableScheduling
public class Queue_Produce {
    // JMS模板
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 这个是我们配置队列的目的地
    @Autowired
    private Queue queue;

    // 发送消息
    public  void  produceMessage(){
        // 一参是目的地， 二参是消息的内容
        jmsMessagingTemplate.convertAndSend(queue, "****"+ UUID.randomUUID().toString().substring(0,6));

    }


    public void produceMessageScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"** scheduled **"+ UUID.randomUUID().toString().substring(0,6));
         System.out.println("  produceMessage  send   ok   ");
    }
}
