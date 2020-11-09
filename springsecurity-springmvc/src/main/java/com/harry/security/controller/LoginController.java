package com.harry.security.controller;


import com.harry.security.model.AuthenticationRequest;
import com.harry.security.model.UserDto;
import com.harry.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version 1.0
 **/
//@RestController
//public class LoginController {
//
//    @Autowired
//    AuthenticationService authenticationService;
//
//    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
//    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
//        UserDto userDto = authenticationService.authentication(authenticationRequest);
//        //存入session
//        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);
//        return userDto.getUsername() +"登录成功";
//    }
//
//    @GetMapping(value = "/logout",produces = {"text/plain;charset=UTF-8"})
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "退出成功";
//    }
//
//    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
//    public String r1(HttpSession session){
//        String fullname = null;
//        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
//        if(object == null){
//            fullname = "匿名";
//        }else{
//            UserDto userDto = (UserDto) object;
//            fullname = userDto.getFullname();
//        }
//        return fullname+"访问资源r1";
//    }
//    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
//    public String r2(HttpSession session){
//        String fullname = null;
//        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
//        if(userObj != null){
//            fullname = ((UserDto)userObj).getFullname();
//        }else{
//            fullname = "匿名";
//        }
//        return fullname + " 访问资源2";
//    }
//}
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return " 登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return " 访问资源1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return " 访问资源2";
    }
}
