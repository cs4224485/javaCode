package com.harry.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduceProperty {
    // Linux上部署的activemq的IP地址+activemq的端口号
    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";
    // 目的地的名称
    public static final String QUEUE_NAME = "topic_demon";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(QUEUE_NAME);
        MessageProducer messageProducer = session.createProducer(topic);
        for (int i = 1; i < 4; i++) {
            // 发送MapMessage  消息体。set方法: 添加，get方式：获取
            MapMessage  mapMessage = session.createMapMessage();
            mapMessage.setString("name", "张三"+i);
            mapMessage.setInt("age", 18+i);
            // 调用Message的set*Property()方法，就能设置消息属性。根据value的数据类型的不同，有相应的API。
            mapMessage.setStringProperty("From","ZhangSan@qq.com");
            mapMessage.setByteProperty("Spec", (byte) 1);
            mapMessage.setBooleanProperty("Invalide",true);
            messageProducer.send(mapMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("*** 消息发送到MQ完成 ***");
    }
}
