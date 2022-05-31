package com.harry.netty.dubborpc.provider;

import com.harry.netty.dubborpc.publicinterface.HelloService;

public class HelloServiceImpl implements HelloService {

    private static int count = 0;
    //当有消费方调用该方法时， 就返回一个结果
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息= " + msg);
        System.out.println();
        // 根据msg 返回不同结果
        if(msg != null) {
            return "你好客户端, 我已经收到你的消息。消息为：[" + msg + "] ，第" + (++count) + " 次 \n";
        } else {
            return "你好客户端, 我已经收到你的消息 ";
        }
    }
}
