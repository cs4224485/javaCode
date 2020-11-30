package com.harry.activemq;
//
//import com.harry.activemq.mq.Queue_Produce;
import com.harry.activemq.mq.Queue_Produce;
import com.harry.activemq.mq.Topic_Produce;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

// 加载spring的junit
//@SpringBootTest(classes = DemoApplication.class)
//@WebAppConfiguration
//public class TestActiveMQ {
//    @Resource // 这个是java的注解， 而Autowried是spring的
//    private Queue_Produce queue_produce;
//    @Resource
//    private Topic_Produce topic_produce;
//
//    @Test
//    public void testSend(){
//        queue_produce.produceMessageScheduled();
//    }
//
//    @Test
//    public void testSendTopic(){
//        topic_produce.produceTopic();
//    }
//}
