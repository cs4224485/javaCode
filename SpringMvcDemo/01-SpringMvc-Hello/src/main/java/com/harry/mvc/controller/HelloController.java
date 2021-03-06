package com.harry.mvc.controller;

import com.harry.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes(value={"User"}, types={String.class})
public class HelloController {
    @RequestMapping("/testSA")
    public String testSessionAttributes(Map<String, Object> map){
        map.put("user", "Caishuang");
        return "success";
    }

    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     *   1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     *   2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
                        Map<String, Object> map) {
        System.out.println("modelAttribute method");
        if (id != null) {
            //模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
            System.out.println("从数据库中获取一个对象: " + user);

            map.put("user", user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改: " + user);
        return "success";
    }


    @RequestMapping("/hello")
    public String helloWorld(ModelMap modelMap){
        modelMap.addAttribute("hello", "hello world CaiShuang");
        return "success";
    }

    @RequestMapping("/test/{num}")
    public String testPathVariable(@PathVariable(value = "num") String num, Map<String, Object> map){
        System.out.println(num);
        map.put("num", num);
        return "success";
    }

}
