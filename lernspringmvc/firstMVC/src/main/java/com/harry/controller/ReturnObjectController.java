package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnObjectController {
    @RequestMapping(name = "/returnString.do", produces = "text/html;charset=utf-8")
    @ResponseBody // 将返回值添加到响应体中
    public Object returnString() throws Exception{
        return "harry.cai,蔡";
    }
    @RequestMapping("/returnMap.do")
    @ResponseBody
    public Object returnMap() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("world", "世界");
        return map;
    }
}
