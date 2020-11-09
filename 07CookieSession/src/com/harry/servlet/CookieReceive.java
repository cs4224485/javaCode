package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接收客户端请求携带的cookie
 */
public class CookieReceive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            System.out.println("没有cookie");
        } else {
            for (Cookie c : cookies) {
                System.out.println("name" + c.getName());
                System.out.println("value" + c.getValue());
            }
        }

    }
}
