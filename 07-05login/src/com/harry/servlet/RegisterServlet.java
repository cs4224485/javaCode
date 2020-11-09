package com.harry.servlet;

import com.harry.javabean.User;
import com.harry.service.imlp.UserService;
import com.harry.service.imlp.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User u = new User();

//        u.setName(req.getParameter("name"));
//        u.setPassword(req.getParameter("password"));
//        u.setEmail(req.getParameter("email"));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
//        try {
//            Date birthday = sdf.parse(req.getParameter("birthday"));
//            u.setBirthday(birthday);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        // 使用apache commons-beanutil解决赋值问题, User对象中属性的名字必须与表单的name值保持一致
        try {
            // 因为User中的birthday是Date类型, 所以需要先注册一个日期转换器
            DateTimeConverter dtConverter = new DateConverter();
            dtConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dtConverter, Date.class);
            BeanUtils.populate(u,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用业务逻辑
        UserService us = new UserServiceImpl();
        try {
            // 判断用户名是否重复
            User result = us.findUserByName(u);
            if(result != null){
                req.setAttribute("msg" , "用户名重复");
                req.getRequestDispatcher("regist.jsp").forward(req,resp);
            }else {
                us.addUser(u);
                // 分发转向
                resp.getWriter().write("注册成功！ 1秒后调整至主页");
                resp.setHeader("refresh", "1;url="+ req.getContextPath() + "/login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
