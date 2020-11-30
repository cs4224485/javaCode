package com.harry.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    // Linux上部署的activemq的IP地址+activemq的端口号
    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";
    // 目的地的名称
    public static final String QUEUE_NAME = "queue_demon";

    public static void main(String[] args) throws JMSException {
        // 1 按照给定的url创建连接工厂，这个构造器采用默认的用户名密码。该类的其他构造方法可以指定用户名和密码。
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工厂, 获取连接connection并启动访问。
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3 创建会话session。 第一参数是是否开启事务， 第二参数是消息签收的方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地(两种：队列/主题)。Destination是Queue和Topic的父类
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5 创建消费的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        // 设置消息持久化
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 6 通过messageProducer生产3条 消息发送到消息队列中
        for (int i = 1; i < 4; i++) {
            // 7 创建消息
            TextMessage textMessage = session.createTextMessage("msg" + i);
            // 8 通过messageProducer发送给mq
            messageProducer.send(textMessage);
        }
        // 9 关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("*** 消息发送到MQ完成 ***");
    }
}
