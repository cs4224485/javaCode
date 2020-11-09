package com.harry.servlet;

import com.harry.servlet.bean.Book;
import com.harry.servlet.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShowBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 获取书籍数据
        Map<String, Book> books = DBUtil.findAllBooks();
        for(Map.Entry<String, Book> book:books.entrySet()){
            String url1 = req.getContextPath()+"/AddCart?id="+book.getKey();
            out.print("<a href='"+url1+"' >"+book.getValue().getName()+"</a><br/>");
        }
        String url2 = req.getContextPath()+"/ShowCart";
        out.print("<a href='"+url2+"'>查看购物车</a> <br/>");

        String url3 = req.getContextPath()+"/ClearCart";
        out.print("<a href='"+url3+"'>清空购物车</a> <br/>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
