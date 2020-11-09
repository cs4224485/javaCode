package com.harry.spring.service.bean;

import com.harry.spring.service.bean.Car;
import com.harry.spring.service.bean.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonBeanFactory {
    // 静态工厂来创建Bean
    public static Person getPerson(String name, int age, Map carMap){
        return new Person(name, age, carMap);
    }
}
