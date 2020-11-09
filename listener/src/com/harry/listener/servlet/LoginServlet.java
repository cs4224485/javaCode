package com.harry.listener.servlet;

import com.harry.listener.offlineUser.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 将获取的用户名放到User对象中
        User user = new User();
        user.setName(req.getParameter("name"));
        // 将User对象放到session中
        req.getSession().setAttribute("user", user);
        // 重定向到登录成功页面
        resp.sendRedirect(req.getContextPath()+ "/login_success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
