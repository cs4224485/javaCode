package com.harry.controller;

import com.harry.myexecption.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理controller
 */
@Controller
public class ExceptionController {
    @RequestMapping("/myException.do")
    public ModelAndView myException(String name) throws Exception{
        ModelAndView mv = new ModelAndView();
        if ("jack".equals(name)){
            throw  new MyException("我的自定义异常");
        }
        if (!"jack".equals(name)){
            throw new Exception("异常");
        }
        return mv;
    }
}
