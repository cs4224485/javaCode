package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置post请求的字符编码,此方式只对post请求有效
        req.setCharacterEncoding("UTF-8");
        // 根据html中的name的名字获取用户在input中填写的value值
        String username = req.getParameter("username");
        resp.setCharacterEncoding("utf-8");
        resp.addHeader("Content-type","text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("用户名" + username + "注册成功！<br>");
        out.print("感谢您的注册");
    }
}
