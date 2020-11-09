package com.harry.test;

import com.harry.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser();
        System.out.println("#####################");

        userService.updateUser();
        System.out.println("#####################");

        try {
            userService.selectUserById(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("#####################");


        userService.selectUser();
        System.out.println("#####################");

        userService.deleteUser();
    }

}
