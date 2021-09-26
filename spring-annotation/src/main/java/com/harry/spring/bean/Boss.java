package com.harry.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 默认加在IOC容器中的组件，容器启动会调用无参构造器创建对象，然后再进行初始化、赋值等操作
@Component
public class Boss {

    private Car car;

    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return "Boss [car=" + car + "]";
    }

}
