package com.harry.spring.service.bean;

import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private int age;
    private Map<String, Car> carMap;

    public Person() {
    }

    public Person(String name, int age, Map<String, Car> carMap) {
        this.name = name;
        this.age = age;
        this.carMap = carMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }
    public void init(){
        System.out.println("Bean被创建");
    }

    public void destroy(){
        System.out.println("Bean销毁");
    }
}
