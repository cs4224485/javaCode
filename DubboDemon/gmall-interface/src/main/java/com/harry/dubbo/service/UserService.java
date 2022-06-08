package com.harry.dubbo.service;

import com.harry.dubbo.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressList(String userId);
}
