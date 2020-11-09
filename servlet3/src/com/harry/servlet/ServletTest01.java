package com.harry.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 使用注解注册servlet
 */

@WebServlet(value = {"/servlet1", "/abc/servlet1"},
            name = "serlvetname1",
            loadOnStartup = 2,
            initParams = {@WebInitParam(name = "teacher", value = "harry"), @WebInitParam(name = "course",value = "java")})
public class ServletTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        //获取servlet名称
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        // 获取初始化参数
        Enumeration<String> params = servletConfig.getInitParameterNames();
        while (params.hasMoreElements()){
            String name = params.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println(name +":"+value);
        }
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
