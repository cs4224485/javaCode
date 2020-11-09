package com.harry.spring.controller;

import com.harry.spring.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(String username, String password, ModelMap map, HttpSession session){
        System.out.println(username+":"+password);
        String msg = "用户名或密码错误";
        if (username.equals("ee")){
            throw new UserNotExistException();
        }
        if (username.equals("harry") && password.equals("123456")){
            session.setAttribute("loginUser", "harry");
            return "redirect:/main.html";
        }
        map.addAttribute("msg", msg);
        return "login";
    }}
