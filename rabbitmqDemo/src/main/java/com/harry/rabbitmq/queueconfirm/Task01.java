package com.harry.rabbitmq.queueconfirm;

import com.harry.rabbitmq.untils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Task01 {
    public final static int MESSAGECOUNT = 1000;
    public static void main(String[] args) throws Exception {
//        publishMessageIndividually();
//        publishMessageBatch();
        publishMessageAsync();
    }

    public static void publishMessageIndividually() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        // 开启发布确认
        channel.confirmSelect();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGECOUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 服务端返回false或超时时间内未返回，生产者可以消息重发
            boolean flag = channel.waitForConfirms();
            if (flag){
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGECOUNT + "个单独确认消息,耗时" + (end - begin) + "ms");
    }
    public static void publishMessageBatch() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        // 开启发布确认
        channel.confirmSelect();
        // 批量确认消息大小
        int batchSize = 100;
        // 未确认消息个数
        int outstandingMessageCount = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i <MESSAGECOUNT ; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            outstandingMessageCount++;
            if (outstandingMessageCount == batchSize){
                channel.waitForConfirms();
                outstandingMessageCount = 0;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGECOUNT + "个单独确认消息,耗时" + (end - begin) + "ms");
    }
    public static void publishMessageAsync() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        // 开启发布确认
        channel.confirmSelect();
        /**
         *
         线程安全有序的一个哈希表，适用于高并发的情况
         * 1.轻松的将序号与消息进行关联
         * 2.轻松批量删除条目 只要给到序列号
         * 3.支持并发访问
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();
        /***
         * 确认收到消息的一个回调, 将消息清除
         * 1. 消息序列号
         * 2. true可以确认小于等于当前序列号的消息， false确认当前序列号消息
         */

        ConfirmCallback ackCallback = (sequenceNumber, multiple) ->{
          if (multiple){
              System.out.println("确认发送消息"+sequenceNumber);
              // 返回的是小于等于当前序列号的未确认消息是一个map
              ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(sequenceNumber, true);
              // 清楚该部分未确认消息
              confirmed.clear();;
          }else {
              // 只清楚当前序列号的消息
              outstandingConfirms.remove(sequenceNumber);
          }
        };
        ConfirmCallback nackCallback = (sequenceNumber, multiple) ->{
            String message = outstandingConfirms.get(sequenceNumber);
            System.out.println("发布的消息" + message + "未被确认，序列号" + sequenceNumber);
        };

        /***
         * 添加一个异步确认的监听器
         * 1. 确认收到消息的回调
         * 2. 未收到消息的回调
         */
        channel.addConfirmListener(ackCallback, nackCallback);
        long begin = System.currentTimeMillis();
        for (int i = 0; i <MESSAGECOUNT ; i++) {
            String message = "消息"+ i;
            /***
             * channel.getNextPublishSeqNo()获取下一个消息的序列号
             * 通过序列号与消息体进行一个关联
             * 全部都是未确认的消息体
             */
            if (i % 100 != 0){
                outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
                channel.basicPublish("", queueName, null, message.getBytes());
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGECOUNT + "个单独确认消息,耗时" + (end - begin) + "ms");
    }
}
