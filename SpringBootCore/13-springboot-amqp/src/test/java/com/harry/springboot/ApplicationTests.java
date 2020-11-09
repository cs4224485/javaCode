package com.harry.springboot;

import com.harry.springboot.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    public void createExchange(){

    }

    @Test
    void contextLoads() {
        // 单播(点对点)
        //Message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange, routeKey, message)

        //object默认当成消息体只需传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange, routeKey,object)
         Map<String,Object> map = new HashMap<>();
         map.put("msg", "这是第一个消息");
         map.put("data", Arrays.asList("helloworld", 123, true));
         rabbitTemplate.convertAndSend("harry.dircect", "harry.news", map);

    }

    @Test
    public void receive(){
        // 接受数据
        Object o = rabbitTemplate.receiveAndConvert("harry.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("harry.fanout","",new Book("红楼梦","曹雪芹"));
    }
}
