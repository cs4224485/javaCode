package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController03 {
    @RequestMapping("/test3.do")
    public ModelAndView test() throws Exception{
        ModelAndView mv = new ModelAndView();
        System.out.println("test方法");
        mv.setViewName("result");
        return mv;
    }
}
