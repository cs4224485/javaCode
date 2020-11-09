package com.harry.dao.impl;

import com.harry.javabean.User;

/**
 *
 * 用户dao
 */
public interface UserDao {
    /**
     *
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws Exception;
    public User findUserByNameAndPassword(User user) throws Exception;
    public User findUserByName(User user) throws Exception;
}
