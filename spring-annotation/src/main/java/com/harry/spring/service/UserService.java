package com.harry.spring.service;

import com.harry.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成...");
        int i = 10 / 0;
    }

    // 一些其他的方法...

    // @EventListener(classes=ApplicationEvent.class)
    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("UserService...");
    }

}
