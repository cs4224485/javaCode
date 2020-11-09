package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 获取表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        System.out.println(password);
        System.out.println(username);
        if ("admin".equals(username) && "123456".equals(password)) {
            out.write("登录成功");
            // 用户勾选了十天内自动登录
            if(remember != null){
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(60 * 60 * 240);
                cookie2.setMaxAge(60 * 60 * 240);
                // 设置cookie路径
                cookie1.setPath("/");
                cookie2.setPath("/");
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
        } else {
            out.write("登录失败,请重新输入");
            // 设置2秒后跳转到重新登录
            resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
