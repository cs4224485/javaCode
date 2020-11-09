package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 使用HttpServlet接收请求数据
 */
public class RequestTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置post请求的字符编码,此方式只对post请求有效
        req.setCharacterEncoding("UTF-8");
        // 根据html中的name的名字获取用户在input中填写的value值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 获取用户勾选的checkbox值
        String[] hobby = req.getParameterValues("hobby");
        System.out.println(username);
        System.out.println(password);
        for (String s:hobby){
            System.out.println(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
