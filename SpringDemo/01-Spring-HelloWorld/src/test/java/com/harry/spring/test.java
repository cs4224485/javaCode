package com.harry.spring;

import com.harry.spring.service.HelloService;
import com.harry.spring.service.UserService;
import com.harry.spring.service.bean.Car;
import com.harry.spring.service.bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person4");
        System.out.println(person.getCarMap());
        System.out.println(person.getName());
        Car car3 = (Car) applicationContext.getBean("car3");
        System.out.println(car3.getName());
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-generic-di.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.add();
    }
}
