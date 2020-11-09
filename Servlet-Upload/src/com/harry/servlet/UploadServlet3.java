package com.harry.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 临时目录
 */
public class UploadServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.判断表单是否支持文件上传
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            throw new RuntimeException("该请求不支持文件上传");
        }
        //2.创建一个DiskFileItemFactory对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String tempPath = this.getServletContext().getRealPath("/temp");
        // **** 指定临时文件存储的目录
        factory.setRepository(new File(tempPath));
        //3.创建ServletFileUpload对象，该对象是上传的核心组件
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //4.解析request对象，并获得表单项集合
        try {
            List<FileItem> fileItems = sfu.parseRequest(req);
            // 5.遍历表单项集合
            for (FileItem item : fileItems) {
                if (item.isFormField()) {
                    // 普通表单 type='text'
                    String fieldName = item.getFieldName(); // 字段名
                    String fileValue = item.getString("utf-8"); // 字段值
                    System.out.println(fieldName + ":" + fileValue);
                } else {
                    // 上传表单项
                    // 获取文件名
                    String fileName = item.getName();
                    // 获取输入流
                    InputStream is = item.getInputStream();
                    // 创建输出流
                    String path = this.getServletContext().getRealPath("/upload");
                    File file = new File(path, fileName);
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = is.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    /*
                        临时文件一旦用完，就可将其删除了，否则占用服务器的硬盘空间。
                        需要注意的是，对于临时文件的删除，需要在 IO 流关闭后，否则，无法删除。
                    */
                    is.close();
                    fos.close();
                    item.delete();
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
