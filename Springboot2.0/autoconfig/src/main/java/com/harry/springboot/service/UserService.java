package com.harry.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.harry.springboot.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService  extends IService<User> {
    User getUserById(int id);
}
