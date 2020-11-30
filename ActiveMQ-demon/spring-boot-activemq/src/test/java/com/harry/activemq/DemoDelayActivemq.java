package com.harry.activemq;

import com.harry.activemq.bean.MessageModel;
import com.harry.activemq.mq.DelayProducer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jms.ConnectionFactory;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoDelayActivemq {
    /**
     * 消息生产者
     */
   @Autowired
    private DelayProducer producer;

    /**
     * 及时消息队列测试
     */
    @Test
    public void test() {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage("测试消息");
        messageModel.setTitile("消息0000");
        System.out.println("发送消息" + messageModel.getMessage());
        // 发送消息
        producer.send(DelayProducer.DEFAULT_QUEUE, messageModel);
    }


    /**
     * 延时消息队列测试
     */
    @Test
    public void test2() {
        for (int i = 0; i < 5; i++) {
            MessageModel messageModel = new MessageModel();
            messageModel.setMessage("测试消息");
            messageModel.setTitile("消息0000");
            System.out.println("发送延迟消息+" + messageModel.getMessage());
            // 发送延迟消息
            producer.delaySend(DelayProducer.DEFAULT_QUEUE, messageModel, 30000L);
        }
        try {
            // 休眠100秒，等等消息执行
            Thread.currentThread().sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
