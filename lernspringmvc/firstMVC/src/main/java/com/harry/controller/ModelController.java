package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * model接口， 可以用来传递数据
 */

@Controller
public class ModelController {
    @RequestMapping("/modeData.do")
    public String modelData(Model model, String name){
        model.addAttribute("username", name);
        return "welcome";
    }
}
