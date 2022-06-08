package com.harry.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.harry.dubbo.bean.UserAddress;
import com.harry.dubbo.dao.UserAddressDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserAddressDao userAddressDao;

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return userAddressDao.getUserAddressById(userId);
    }
}
