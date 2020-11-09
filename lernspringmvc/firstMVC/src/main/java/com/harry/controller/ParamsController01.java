package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class ParamsController01 {
    @RequestMapping("/params01")
    public ModelAndView getParam01(@RequestParam(name="username") String t_username, @RequestParam(name="age", defaultValue = "18") int t_age) throws Exception{
        // 方法的参数名需要跟前台页面中的表单里面的input的name一致
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", t_username);
        mv.addObject("age", t_age);
        mv.setViewName("result");
        return mv;
    }
}
