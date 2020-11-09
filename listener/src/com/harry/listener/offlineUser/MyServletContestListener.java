package com.harry.listener.offlineUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听ServletContext的初始化, 初始化时创建一个map
 */
public class MyServletContestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // map的key存放用户, value存放该用户的信息
        Map<String, HttpSession> map = new HashMap<String, HttpSession>();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("map",map);
    }
}
