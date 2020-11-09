package com.harry.test;

import com.harry.service.StudentService;
import com.harry.service.imlp.StudentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test01 {
    /**
     * 以前的写法，手动创建对象
     */
    public void oldTyoe(){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.study();
    }
    @Test
    public void newType(){
        // 读取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService =(StudentService)context.getBean("studentService");
        studentService.study();
    }
    @Test
    public void beanFactory(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("G:\\learnspring\\firstspring\\src\\main\\resources\\applicationContext.xml"));
        StudentService studentService =(StudentService)factory.getBean("studentService");
    }
}
