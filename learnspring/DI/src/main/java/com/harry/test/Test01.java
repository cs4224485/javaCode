package com.harry.test;


import com.harry.service.UserService;
import com.harry.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test01 {

    @Test
    public void newType(){
        // 读取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =(UserServiceImpl)context.getBean("userService");
        userService.addUser();
    }
    @Test
    public void testInitAndDestroy(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =(UserServiceImpl)context.getBean("userService");
        userService.addUser();
        // 关闭容器
        ((ClassPathXmlApplicationContext)context).close();

    }

    public void testFiles(){
        // 将spring相关的配置文件的文件名写到String类型的数组中
        String[] files = {"applicationContext.xml", "spring-aop.xml", "spring-bean.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(files);
        UserService userService =(UserServiceImpl)context.getBean("userService");

    }
}
