package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *  spring mvc中的转发和重定向
 */
@Controller
public class ForwardController {
    /**
     * 返回ModelAndView对象的装发
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/forwardMAV.do")
    public ModelAndView forwardMAV() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("type", "返回ModelAndView对象的转发");
        // 默认使用转发进行跳转
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/redirectMAV.do")
    public ModelAndView redirectMAV() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("type", "返回ModelAndView对象的重定向");
        // 重定向
        mv.setViewName("redirect:/jsp/result.jsp");
        return mv;
    }
}
