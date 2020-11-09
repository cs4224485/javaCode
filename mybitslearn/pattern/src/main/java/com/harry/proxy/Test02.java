package com.harry.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test02 {
    public static void main(String[] args) {
        final Boss boss = new Boss();
        //ProxyLawer lawer = new ProxyLawer(boss);
        // jdk的动态代理创建代理对象
        law law = (law)Proxy.newProxyInstance(boss.getClass().getClassLoader(), boss.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("打官司前的准备工作");
                Object invoke = method.invoke(boss);
                System.out.println("结果");
                return invoke;

            }
        });
        Employee ep = new Employee(law);
        ep.forMoney();
    }
}
