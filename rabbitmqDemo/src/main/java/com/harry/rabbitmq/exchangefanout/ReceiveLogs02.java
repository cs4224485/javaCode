package com.harry.rabbitmq.exchangefanout;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class ReceiveLogs02 {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        // 把该临时队列绑定我们的exchange 其中routingkey（也称之为binding key）为空字符串
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("等带接收消息，把接收到的消息打印到控制台");
        DeliverCallback deliverCallback = (consumerTag, delivery) ->{
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            File file = new File("C:\\work\\rabbitmq_info.txt");
            FileUtils.writeStringToFile(file,message,"UTF-8");
            System.out.println("数据写入文件成功");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});

    }
}
