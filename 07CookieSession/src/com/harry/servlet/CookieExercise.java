package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieExercise extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastLogin".equals(cookies[i].getName())) {
                // 拿到上一次的访问时间
                long time = Long.parseLong(cookies[i].getValue());
                out.write("你的上次访问时间是："+ new Date(time).toLocaleString());
            }
        }
        Cookie cookieUsername = new Cookie("username", "admin");
        Cookie cookieLoginTime = new Cookie("lastLogin", System.currentTimeMillis() + "");
        cookieLoginTime.setMaxAge(60 * 60);
        resp.addCookie(cookieLoginTime);
        resp.addCookie(cookieUsername);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
