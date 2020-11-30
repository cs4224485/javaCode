package com.harry.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.io.IOException;

public class DelayQueueProducer {
    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";
    public static final String QUEUE_NAME = "Delay";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);
        long delay =  10*1000;
        long period = 5*1000;
        int repeat = 3 ;
        try {
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = session.createTextMessage("tx msg--" + i);
                // 延迟的时间
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                // 重复投递的时间间隔
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
                // 重复投递的次数
                textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
                producer.send(textMessage);
            }
            session.commit();
            System.out.println("消息发送完成");
        } catch (Exception e) {
            System.out.println("出现异常,消息回滚");
            session.rollback();
        } finally {
            producer.close();
            session.close();
            connection.close();
        }

    }
}
