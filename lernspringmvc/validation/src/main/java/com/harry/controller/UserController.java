package com.harry.controller;

import com.harry.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // @Validated不能加载String类型或者是基本数据类型的前面
    // BindingResult可以获取所有验证异常的信息
    @RequestMapping("/register")
    public ModelAndView register(@Validated User user, BindingResult br){
        ModelAndView mv = new ModelAndView();
        List<ObjectError> allErrors = br.getAllErrors();
        // 如果数据校验不通过，就会进入到下面的判断中
        if (allErrors != null && allErrors.size() > 0){
            FieldError nameError = br.getFieldError("name");
            FieldError ageError = br.getFieldError("age");
            FieldError phoneError = br.getFieldError("phone");
            if (nameError != null){
                mv.addObject("nameError", nameError.getDefaultMessage());
            }
            if (ageError != null){
                mv.addObject("ageError", ageError.getDefaultMessage());
            }
            if (phoneError != null){
                mv.addObject("phoneError", phoneError.getDefaultMessage());
            }
            mv.setViewName("register");
            return mv;
        }
        mv.addObject("msg", "注册成功");
        mv.setViewName("user");
        return mv;
    }
}
