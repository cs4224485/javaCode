package com.harry.controller;

import com.alibaba.fastjson.JSON;
import com.harry.bean.User;
import com.harry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/users")
    public String selectUser(){
        List<User> users = userService.selectUser();
        return JSON.toJSONString(users);
    }

    /**
     * 根据ID进行查询
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public String selectUserById(@PathVariable int id){
        User user = userService.selectUserById(id);
        return JSON.toJSONString(user);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        try{
            userService.addUser(user);
            // 如果成功的话就返回success
            return JSON.toJSONString("success");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        try {
            userService.updateUser(user);
            return JSON.toJSONString("success");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        try{
            userService.deleteUser(id);
            return JSON.toJSONString("success");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
    }
}
