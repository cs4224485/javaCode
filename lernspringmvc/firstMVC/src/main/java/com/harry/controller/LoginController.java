package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录
 */

@Controller
public class LoginController {
    @RequestMapping("/welcome")
    public ModelAndView welcome() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("welcome", "欢迎登录本系统");
        mv.setViewName("/welcome");
        return mv;
    }
}
