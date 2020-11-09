package com.harry.dao;

import com.harry.bean.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    List<User> selectUser();

    User selectUserById(int id);

    void deleteUser(int id);

}
