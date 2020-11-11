package com.harry.security.oauth2.order.controller;

import com.harry.security.oauth2.order.model.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDto.getUsername() + "访问资源1";
    }
    @PreAuthorize("hasAnyAuthority('p2')")
    @GetMapping(value = "/r2")
    public String r2(){
        // 通过Spring Security API获取当前登录用户
        UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDto.getUsername() + "访问资源2";
    }

}
