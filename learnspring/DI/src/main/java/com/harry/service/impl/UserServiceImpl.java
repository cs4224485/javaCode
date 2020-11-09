package com.harry.service.impl;

import com.harry.Dao.UserDao;
import com.harry.Dao.impl.UserDaoImpl;
import com.harry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void addUser() {
        // 以前需要手动创建对象
        // userDao = new UserDaoImpl();
        // userDao.addUser();
        userDao.addUser();
    }
    @PostConstruct
    public void before(){
        System.out.println("开始");
    }
    @PreDestroy
    public void after(){
        System.out.println("销毁");
    }
}
