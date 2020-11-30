package com.harry.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerProperty {
    public static final String ACTIVEMQ_URL = "tcp://192.168.30.128:61616";

    public static final String TOPIC_NAME = "topic_demon";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        /***
         * 通过监听的方式来消费消息，是异步非阻塞的方式消费消息。
         * 通过messageConsumer的setMessageListener注册一个监听，当有消费发送来时，系统自动调用MessageListener的onMessage方法处理消息
         */
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                // instanceof 判断是否A对象是否是B类的子类
                if (null != message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("****消费者的消息：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
                if (null != message  && message instanceof MapMessage){
                    MapMessage mapMessage = (MapMessage)message;
                    try {
                        System.out.println("****消费者的map消息："+mapMessage.getString("name"));
                        System.out.println("****消费者的map消息："+mapMessage.getInt("age"));
                        System.out.println("消息属性："+mapMessage.getStringProperty("From"));
                        System.out.println("消息属性："+mapMessage.getByteProperty("Spec"));
                        System.out.println("消息属性："+mapMessage.getBooleanProperty("Invalide"));

                    }catch (JMSException e) {
                    }
                }

            }
        });
        // 让主线程不要结束。因为一旦主线程结束了，其他的线程（如此处的监听消息的线程）也都会被迫结束。
        // 实际开发中，我们的程序会一直运行，这句代码都会省略。
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();

    }
}
