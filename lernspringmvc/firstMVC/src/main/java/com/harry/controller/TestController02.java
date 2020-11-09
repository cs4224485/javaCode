package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")// 表示一个命名空间,namespace
public class TestController02 {
    @RequestMapping(value = "/test2.do", method = RequestMethod.GET)
    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "test2");
        mv.setViewName("test1");
        return mv;
    }
    @RequestMapping({"/hello.do", "/world.do"})
    public ModelAndView test3(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello world");
        mv.setViewName("test1");
        return mv;
    }

}
