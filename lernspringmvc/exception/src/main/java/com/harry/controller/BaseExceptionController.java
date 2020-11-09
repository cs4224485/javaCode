package com.harry.controller;

import com.harry.myexecption.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseExceptionController {
    /**
     * 处理MyException异常的方法
     * @param ex
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ModelAndView handleMyException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/error/MyError");
        return mv;
    }

    /**
     * 其他异常处理，注解中不用写value属性
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ModelAndView handleException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/error/error");
        return mv;
    }
}
