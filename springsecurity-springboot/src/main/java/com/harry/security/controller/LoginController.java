package com.harry.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

@RestController
public class LoginController {
    @RequestMapping(value = "/login-success")
    public String loginSuccess(){
        String username = getUsername();
        return username+"登录成功";
    }

    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.isAuthenticated()){
            return null;
        }
        Object principal = authentication.getPrincipal();
        String username = null;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else {
            username = principal.toString();
        }
        return username;
    }

    @GetMapping(value = "/r/r1")
    public String r1(){
        String username = getUsername();
        return username + "访问资源1";
    }

    @GetMapping(value = "r1/r2")
    public String r2(){
        String username = getUsername();
        return username + "访问资源2";
    }
}
