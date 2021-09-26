package com.harry.spring.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    private String name;
    private Integer age;

    @Value("${person.nickName}")
    private String nickName; // 昵称
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
