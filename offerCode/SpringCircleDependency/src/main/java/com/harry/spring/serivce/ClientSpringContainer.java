package com.harry.spring.serivce;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientSpringContainer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.getBean("a", A.class);
        applicationContext.getBean("b", B.class);
    }
}
