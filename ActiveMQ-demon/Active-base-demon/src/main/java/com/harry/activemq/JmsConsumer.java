package com.harry.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

// 消息的消费者
public class JmsConsumer {

    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";

    public static final String QUEUE_NAME = "queue_demon";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        while (true){
            // receive() 一直等待接收消息，在能够接收到消息之前将一致阻塞。是同步阻塞方式。和socket的accept方法类似的
            // receive（Long time）: 等待n毫秒之后没有收到消息，就结束阻塞。
            // 因为消息发送者是TextMessage 所以消息接受者也要是TextMessage
            TextMessage message = (TextMessage) messageConsumer.receive();
            if(null != message){
                System.out.println("****消费者的消息："+ message.getText());
            }else {
                break;
            }


        }
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
