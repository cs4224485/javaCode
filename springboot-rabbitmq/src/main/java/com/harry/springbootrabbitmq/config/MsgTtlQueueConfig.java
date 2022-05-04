package com.harry.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author cs1
 */
@Configuration
public class MsgTtlQueueConfig {
    public static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    public static final String QUEUE_C = "QC";

    // 声明队列C死信交换机
    @Bean("queueC")
    public Queue queueC() {
        HashMap<String, Object> args = new HashMap<>(3);
        // 声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", "YD");
        // 没有声明ttl属性
        return QueueBuilder.durable(QUEUE_C).withArguments(args).build();

    }

    // 声明队列B绑定X交换机
    @Bean
    public Binding queuecBingdingX(@Qualifier("queueC") Queue queueC,
                                   @Qualifier("xExchange") DirectExchange X_EXCHANGE) {
        return BindingBuilder.bind(queueC).to(X_EXCHANGE).with("XC");
    }
}
