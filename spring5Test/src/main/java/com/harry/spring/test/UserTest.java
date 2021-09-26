package com.harry.spring.test;

import com.harry.spring.Dao.UserDao;
import com.harry.spring.bean.Course;
import com.harry.spring.bean.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

public class UserTest {
    @Test
    public void testAdd() {
        //1 加载 spring 配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void test3() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
}
