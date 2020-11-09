package com.harry.service.imlp;

import com.harry.dao.impl.UserDao;
import com.harry.dao.impl.UserDaoImpl;
import com.harry.javabean.User;

public class UserServiceImpl implements UserService{
     private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) throws Exception{
        userDao.addUser(user);
    }

    @Override
    public User findUserByNameAndPassword(User user) throws Exception {
        return userDao.findUserByNameAndPassword(user);
    }

    @Override
    public User findUserByName(User user) throws Exception {
        return userDao.findUserByName(user);
    }
}
