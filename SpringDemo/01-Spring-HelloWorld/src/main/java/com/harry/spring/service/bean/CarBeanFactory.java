package com.harry.spring.service.bean;

import java.util.HashMap;
import java.util.Map;

// 实例工厂
public class CarBeanFactory {

    private Map<String, Car> carMap;

    public CarBeanFactory() {
        carMap = new HashMap<>();
        carMap.put("1", new Car("BMW", "yiiq", 300000));
        carMap.put("2", new Car("大众", "yiiq", 400000));
    }

    public Car getCar(){
        return carMap.get("1");
    }
}
