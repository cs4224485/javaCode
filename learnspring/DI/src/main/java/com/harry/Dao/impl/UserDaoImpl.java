package com.harry.Dao.impl;

import com.harry.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("添加用户");
    }
}
