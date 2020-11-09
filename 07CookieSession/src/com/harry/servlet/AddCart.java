package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 取得图书id
        String id = req.getParameter("id");
        // 获取session对象
        HttpSession session = req.getSession();
        // 将图书的id作为key， 数量作为value存放到map中
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("shoppingCart");
        // 说明session是空，即第一次抽向session中存放数据
        if (map == null) {
            map = new HashMap<String, Integer>();
        }
        // 如果是null的话，则说明还未向购物车添加过该商品
        if (map.get(id) == null) {
            map.put(id, 1);
        } else {
            // 数量+1
            map.put(id, map.get(id) + 1);
        }
        session.setAttribute("shoppingCart", map);
        out.write("购物车添加成功");
    }
}
