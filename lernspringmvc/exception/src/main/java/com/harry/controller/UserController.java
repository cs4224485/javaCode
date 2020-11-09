package com.harry.controller;

import com.harry.myexecption.MyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController extends BaseExceptionController {
    @RequestMapping("/addUser.do")
    public ModelAndView addUser(String name, int age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.addObject("birthady", birthday);
        mv.setViewName("result");
        return mv;
    }
}
