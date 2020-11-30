package com.harry.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Jms_TX_Consumer {
    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";
    public static final String QUEUE_NAME = "Queue-TX";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建会话session，两个参数transacted=事务,acknowledgeMode=确认模式(签收)
        // 消费者开启了事务就必须手动提交，不然会重复消费消息
        final Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        int a = 0;
        messageConsumer.setMessageListener((message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("***消费者接收到的消息:   " + textMessage.getText());
                textMessage.acknowledge();
            } catch (JMSException e) {
                e.printStackTrace();
                System.out.println("出现异常，消费失败，放弃消费");
                try {
                    session.rollback();
                } catch (JMSException jmsException) {
                    jmsException.printStackTrace();
                }
            }
        }
        ));
        //关闭资源
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();

    }
}
