package com.harry.rabbitmq.untils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqUtils {
    public static Channel getChannel() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.31.96");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
}
