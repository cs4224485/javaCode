package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller //表示当前类是一个controller
public class TestController {
    @RequestMapping("/test/test1.do")
    public ModelAndView test1(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello first spring mvd");
        mv.setViewName("first");
        return mv;
    }
}
