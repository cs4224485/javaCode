package com.harry.servlet;
/**
 * 文件下载
 */

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应头属性，使文件以附件的形式下载
        resp.setHeader("content-disposition", "attachment;filename=monkey1024.png");
        // 获取文件的输入流
        InputStream is = this.getServletContext().getResourceAsStream("/download/monkey1024.png");
        // 输出流
        ServletOutputStream os = resp.getOutputStream();
        // 复制文件
        byte[] bytes = new byte[1024];
        int len = 1;
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
