package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 方法中返回String类型
 * 如果只希望方法执行完毕后跳转JSP或其他资源，此时可以使用String作为方法的返回值
 */

@Controller
public class ReturnStringController {
    @RequestMapping("/welcome.do")
    public String welcome() throws Exception{

        return "welcome";
    }

    /**
     * 跳转到外部资源
     * @return
     * @throws Exception
     */
    @RequestMapping("/baidu.do")
    public String goToBaidu() throws Exception{
        // 此处返回的字符串需要跟SpringMVC.xml配置文件中的bean的id保持一致
        return "baidu";
    }
}
