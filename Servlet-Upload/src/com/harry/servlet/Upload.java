package com.harry.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件上传
 */
public class Upload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的输入流
        ServletInputStream is = req.getInputStream();
        // 读取输入流中的数据
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = is.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
    }
}
