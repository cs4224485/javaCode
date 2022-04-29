package com.harry.rabbitmq.workqueue;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.concurrent.TimeUnit;

public class Work03 {
    private static final String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback = (consumerTag, delivery) ->{
            String receivedMessage = new String(delivery.getBody());
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("接收到消息:" + receivedMessage);
                /**
                 * 1.消息标记 tag
                 * 2.是否批量应答未应答消息
                 */
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        CancelCallback cancelCallback =  (consumerTag) ->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        };
        System.out.println("C1 消费者启动等待消费");
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        //采用手动应答
        boolean autoAck=false;
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, cancelCallback);

    }
}
