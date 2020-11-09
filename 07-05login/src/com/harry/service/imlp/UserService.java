package com.harry.service.imlp;

import com.harry.javabean.User;

public interface UserService {
    public void addUser(User user) throws Exception;
    public User findUserByNameAndPassword(User user) throws Exception;
    public User findUserByName(User user) throws Exception;
}
