package com.harry.spring.proxy;

import com.harry.spring.proxy.ArithmeticCalculator;
import com.harry.spring.proxy.ArithmeticCalculatorLoggingProxy;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {

    ArithmeticCalculator arithmeticCalculator;
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        arithmeticCalculator = (ArithmeticCalculator)applicationContext.getBean("arithmeticCalculator");
    }

    @Test
    public void testProxy(){
        System.out.println(arithmeticCalculator);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorLoggingProxy(this.arithmeticCalculator).getLoggingProxy();
        arithmeticCalculator.add(1, 10);


    }
}
