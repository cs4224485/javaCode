package com.harry.rabbitmq.workqueue;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.util.Scanner;

public class Task02 {
    private static final String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println("发送消息完成：" + message);
        }

    }
}
