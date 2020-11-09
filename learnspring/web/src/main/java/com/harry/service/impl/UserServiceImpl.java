package com.harry.service.impl;

import com.harry.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("用户添加");
    }
}
