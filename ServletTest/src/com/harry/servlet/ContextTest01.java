package com.harry.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class ContextTest01 implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext application = this.config.getServletContext();
        // 获取应用的初始化数据
        String driver = application.getInitParameter("MySQLDriver");
        Enumeration<String> configs = application.getInitParameterNames();
        while (configs.hasMoreElements()) {
            System.out.println(configs.nextElement());
        }
        // 获取路径
        String contextPath = application.getContextPath();
        System.out.println("contextPath:" + contextPath);
        // 获取在Servlet class文件在硬盘中的绝对路径
        String realPath = application.getRealPath("ServletFirst");
        System.out.println(realPath);
        // 向ServletContext中添加属性
        application.setAttribute("admin", "tiger");
        application.setAttribute("password", 123456);
        // 删除属性
        application.removeAttribute("password");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
