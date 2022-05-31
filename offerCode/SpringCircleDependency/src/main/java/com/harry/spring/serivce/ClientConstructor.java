package com.harry.spring.serivce;

public class ClientConstructor {
    public static void main(String[] args){
            //创建serviceAA
            ServiceA a = new ServiceA();
            //创建serviceBB
            ServiceB b = new ServiceB();
            //将serviceA入到serviceB中
            b.setServiceA(a);
            //将serviceB法入到serviceA中
            a.setServiceB(b);

    }
}
