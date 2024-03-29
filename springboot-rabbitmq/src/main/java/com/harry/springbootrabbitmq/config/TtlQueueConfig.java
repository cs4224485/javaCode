package com.harry.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TtlQueueConfig {

    public static final String X_EXCHANGE = "X";
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    public static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    public static final String DEAD_LETTER_QUEUE = "QD";

    // 声明xExchange
    @Bean("xExchange")
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    // 声明yExchange
    @Bean("yExchange")
    public DirectExchange yExchange() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }

    // 声明队列A ttl为10s 并绑定到对应的死信交换机
    @Bean("queueA")
    public Queue queueA() {
        HashMap<String, Object> args = new HashMap<>(3);
        // 声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", "YD");
        // 声明队列的TTl
        args.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_A).withArguments(args).build();
    }

    @Bean
    public Binding queueaBindingX(@Qualifier("queueA") Queue queueA,
                                 @Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }


    @Bean("queueB")
    public Queue queueB() {
        HashMap<String, Object> args = new HashMap<>(3);
        // 声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", "YD");
        // 声明队列的TTl
        args.put("x-message-ttl", 40000);
        return QueueBuilder.durable(QUEUE_B).withArguments(args).build();
    }

    // 声明队列B绑定X交换机
    @Bean
    public Binding queuebBindingX(@Qualifier("queueB") Queue queueB,
                                 @Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    // 声明私信队列QD
    @Bean("queueD")
    public Queue queueD(){
        return new Queue(DEAD_LETTER_QUEUE);
    }

    // 声明私信队列QD的绑定关系
    @Bean
    public Binding deadLetterQAD(@Qualifier("queueD") Queue queueD,
                                 @Qualifier("yExchange") DirectExchange yExchange){

        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }
}

