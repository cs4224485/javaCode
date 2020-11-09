package com.harry.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 监听session绑定javabean
 */
public class Student implements HttpSessionBindingListener {
    private String name;
    private int age;

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

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Student对象被添加到session中");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Student对象从session中被删除");
    }
}
