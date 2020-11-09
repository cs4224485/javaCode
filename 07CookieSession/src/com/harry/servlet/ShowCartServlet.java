package com.harry.servlet;

import com.harry.servlet.bean.Book;
import com.harry.servlet.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("您的购物车有以下商品：<br/>");
        HttpSession session = req.getSession();
        Map<String, Integer> books = (Map<String,Integer>)session.getAttribute("shoppingCart");
        if(books == null){
            out.write("购物车为空");
            resp.setHeader("refresh", "2;url" + req.getContextPath() + "/showBook");
            return;
        }else {
            for(Map.Entry<String, Integer> book:books.entrySet()){
                Book b = DBUtil.findBookById(book.getKey());
                out.write("名称:" + b.getName() + ", 数量:" + book.getValue() + "<br/>" );
            }
        }



    }
}
