package com.harry.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 监听对象的活化与钝化
 */

public class Person implements HttpSessionActivationListener, Serializable {
    private static final long serialVersionUid = 189413377798346859L;

    private String name;

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

    private int age;


    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("钝化："+ se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("活化："+ se.getSession().getId());
    }
}
