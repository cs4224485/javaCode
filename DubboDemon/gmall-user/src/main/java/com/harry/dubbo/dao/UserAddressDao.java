package com.harry.dubbo.dao;

import com.harry.dubbo.bean.UserAddress;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserAddressDao {
    public static List<UserAddress> userAddresses = new ArrayList<>();
    static{

        userAddresses.add(new UserAddress(1, "西安高新区", "id-1", "harry", "18629090745", "1"));
        userAddresses.add(new UserAddress(2, "北京海淀区", "id-2", "sam", "18629090745", "0"));
    }

    public List<UserAddress> getUserAddressById(String userId){
        return userAddresses;
    }

}
