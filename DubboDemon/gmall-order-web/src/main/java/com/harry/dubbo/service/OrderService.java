package com.harry.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.harry.dubbo.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    UserService userService;
    /**
     * 初始化订单，查询用户的所有地址并返回
     * @param userID
     * @return
     */
    public List<UserAddress> initOrder(String userID){
        System.out.println(userService);
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);
        System.out.println("当前接收到的userId=> "+userID);
        System.out.println("**********");
        System.out.println("查询到的所有地址为：");
        for (UserAddress userAddress : userAddressList) {
            //打印远程服务地址的信息
            System.out.println(userAddress.getUserAddress());
        }

        return userAddressList;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.initOrder("10");

    }
}
