package com.harry.netty.dubborpc.customer;

import com.harry.netty.dubborpc.netty.NettyClient;
import com.harry.netty.dubborpc.publicinterface.HelloService;

public class ClientBootstrap {

    // 这里定义协议头
    public static final String providerName = "HelloServer#hello#";

    public static void main(String[] args) throws InterruptedException {
        // 创建一个消费者
        NettyClient customer = new NettyClient();

        // 创建代理对象
        HelloService helloService = (HelloService) customer.getBean(HelloService.class, providerName);
        for (;;){
            Thread.sleep(2* 1000);
            String res = helloService.hello("你好 dubbo~");
            System.out.println("调用的结果 res= " + res);
        }
    }
}
