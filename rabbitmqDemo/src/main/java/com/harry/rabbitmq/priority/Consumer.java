package com.harry.rabbitmq.priority;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;

public class Consumer {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 设置队列的最大优先级 最大可以设置到255 官网推荐1-10 如果设置太高比较吃内存和CPU
        HashMap<String, Object> params = new HashMap<>();

        params.put("x-max-priority", 10);
        channel.queueDeclare(QUEUE_NAME, true, false, false, params);
        System.out.println("消费者启动等待消息。。。。。");

        DeliverCallback deliverCallback = (consumerTag, delivery)->{
            String receiveMessage = new String(delivery.getBody());
            System.out.println("接收消息：" + receiveMessage);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag->{
            System.out.println("消费者五大消息消息时调用， 如队列被删除");
        });
    }
}
