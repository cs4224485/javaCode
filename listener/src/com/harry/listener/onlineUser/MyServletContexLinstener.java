package com.harry.listener.onlineUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 监听ServletContext的创建
 */
public class MyServletContexLinstener  implements ServletContextListener {
    /**
     * 当ServletContext创建的时候，初始化一个map,并放到ServletContext中
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, List<HttpSession>> ipMap = new HashMap<String, List<HttpSession>>();
        ServletContext servletContext = sce.getServletContext();
        // 将创建好的map对象放到ServletContext域中
        servletContext.setAttribute("ipMap", ipMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
