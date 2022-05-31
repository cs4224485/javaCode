package com.harry.spring;

import com.harry.spring.service.CalcService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SpringAopTest {

    @Autowired
    CalcService calcService;

    @Test
    public void test01(){
        System.out.println(String.format("Spring Verision : %s, Sring Boot Version : %s.", //
                SpringVersion.getVersion(), SpringBootVersion.getVersion()));

//        calcService.div(10, 2);
        calcService.div(10, 0);//将会抛异常
    }

    @Test
    public void testAopSpring5(){
        System.out.println(String.format("Spring Verision : %s, Sring Boot Version : %s.", //
                SpringVersion.getVersion(), SpringBootVersion.getVersion()));

//        calcService.div(10, 2);
        calcService.div(10, 0);//将会抛异常
    }
}
