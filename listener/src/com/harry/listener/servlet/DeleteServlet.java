package com.harry.listener.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 将用户在线踢出
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取要剔出的用户名
        String name = req.getParameter("name");
        // 获取ServletContext
        HttpSession currentSession = req.getSession();
        ServletContext servletContest = currentSession.getServletContext();
        // 从servletContext域中获取map
        Map<String, HttpSession> map = (Map<String, HttpSession>)servletContest.getAttribute("map");
        HttpSession session = map.get(name);
        // 将用户的session清空并从map中移除
        if(session != null){
            session.invalidate();
            map.remove(name);
        }
        resp.sendRedirect(req.getContextPath() + "/login_success.jsp");
    }


}
