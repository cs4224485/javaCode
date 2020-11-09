package com.harry.controller;

import com.harry.myexecption.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationExceptionController {

    @RequestMapping("/annotation")
    public ModelAndView regist(String name) throws Exception{
        ModelAndView mv = new ModelAndView();
        if("jack".equals(name)){
            throw  new MyException("自定义异常");
        }
        return mv;
    }

    /**
     * 处理MyException异常的方法
     * @param ex
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ModelAndView handleMyException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/error/myerror");
        return mv;
    }
}
