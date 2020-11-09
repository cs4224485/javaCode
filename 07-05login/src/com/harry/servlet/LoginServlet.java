package com.harry.servlet;

import com.harry.javabean.User;
import com.harry.service.imlp.UserService;
import com.harry.service.imlp.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 获取用户提交的表单数据
        User user = new User();
//        user.setName(req.getParameter("name"));
//        user.setPassword(req.getParameter("password"));
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用业务逻辑
        UserService us = new UserServiceImpl();

        try {
            User u = us.findUserByNameAndPassword(user);
            // 根据是否登录成功分发转向
            if(u != null){
                // 输入了正确的用户名和密码, 跳转到登录成功页面
                // 将user数据放到session中 方便以后使用
                req.getSession().setAttribute("user", u);
                req.getRequestDispatcher("/login_success.jsp").forward(req, resp);
            }else {
                req.setAttribute("msg", "用户名或密码不正确");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
