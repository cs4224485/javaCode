package com.harry.spring.service.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Factory;

public class CarFactory implements FactoryBean<Car> {
    // 返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car("保时捷", "SA", 500000);
    }
    // 返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    // 是否是单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
