package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        String username = "";
        String password = "";
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if("username".equals(cookies[i].getName())){
                username = cookies[i].getValue();
            }
            if("password".equals(cookies[i].getName())){
                password = cookies[i].getValue();
            }
        }
        // 判断cookie中的用户名密码是否匹配
        if ("admin".equals(username) && "123456".equals(password)){
            out.write("登录成功");
        }
        out.write("<form action='" + req.getContextPath() + "/doLogin' method='post'>");
        out.write("用户名：<input type='text' name='username' /><br/>");
        out.write("密码：<input type='password' name='password'/><br/>");
        out.write("<input type='checkbox' name='remember' />十天免登陆<br/>");
        out.write("<input type='submit' value='登录'/><br/>");
        out.write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
