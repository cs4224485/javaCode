package com.harry.listener.offlineUser;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;

/**
 * 当用户等时与用户发生绑定
 */

public class User implements HttpSessionBindingListener {
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
        ServletContext servletContext = event.getSession().getServletContext();
        // 获取ServletContext域中的map
        Map<String, HttpSession> map = (Map<String, HttpSession>)servletContext.getAttribute("map");
        // 将用户信息放到map中
        map.put(name, event.getSession());
        servletContext.setAttribute("map", map);
    }
}
