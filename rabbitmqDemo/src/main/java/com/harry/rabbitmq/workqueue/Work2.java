package com.harry.rabbitmq.workqueue;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Work2 {
    private static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C1等待接收消息....");
        DeliverCallback deliverCallback = (consumerTag, delivery) ->{
            String receivedMessage = new String(delivery.getBody());
            try {
                Thread.sleep(10000);
                System.out.println("接收到消息:" + receivedMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        CancelCallback cancelCallback =  (consumerTag) ->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        };
        System.out.println("C2 消费者启动等待消费");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
