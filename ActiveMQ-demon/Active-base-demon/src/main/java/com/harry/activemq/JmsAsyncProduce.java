package com.harry.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

public class JmsAsyncProduce {

    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616?jms.useAsyncSend=true";
    public static final String QUEUE_NAME = "Async";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 方式1
        activeMQConnectionFactory.setUseAsyncSend(true);

        Connection connection = activeMQConnectionFactory.createConnection();
        // 方式2
        ((ActiveMQConnection)connection).setUseAsyncSend(true);
        connection.start();

        //设置为开启事务
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer)session.createProducer(queue);
        try {
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = session.createTextMessage("tx msg--" + i);
                textMessage.setJMSMessageID(UUID.randomUUID().toString()+"orderTEST");
                final String  msgId = textMessage.getJMSMessageID();
                activeMQMessageProducer.send(textMessage, new AsyncCallback() {
                    @Override
                    public void onSuccess() {
                        System.out.println("成功发送消息Id:"+msgId);
                    }

                    @Override
                    public void onException(JMSException e) {
                        System.out.println("失败发送消息Id:"+msgId);
                    }
                });
            }

            session.commit();
            System.out.println("消息发送完成");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常,消息回滚");
            session.rollback();
        } finally {
            activeMQMessageProducer.close();
            session.close();
            connection.close();
        }
    }
}
