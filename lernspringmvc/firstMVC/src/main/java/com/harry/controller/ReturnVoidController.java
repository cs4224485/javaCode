package com.harry.controller;

import com.alibaba.fastjson.JSON;
import com.harry.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

/**
 * 方法没有返回值
 */
@Controller
public class ReturnVoidController {
    @RequestMapping(value = "/servletjump.do", method = {RequestMethod.GET, RequestMethod.POST})
    public void servletJump(HttpServletRequest request, HttpServletResponse response, Student student) throws Exception{
        request.setAttribute("student", student);
        request.getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);

    }

    /**
     * 返回Ajax的请求
     * @param request
     * @param response
     * @param student
     * @throws Exception
     */
    @RequestMapping("/ajaxResponse.do")
    public  void ajaxResponse(HttpServletRequest request, HttpServletResponse response, Student student) throws Exception{
        Writer out = response.getWriter();
        String  jsonString = JSON.toJSONString(student);
        out.write(jsonString);
    }
}
