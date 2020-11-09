package com.harry.controller;

import com.alibaba.fastjson.JSON;
import com.harry.bean.User;
import com.harry.util.DataUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 基于restful风格的增删改查
 */
@RestController
public class UserRestController {
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @GetMapping("/users")
    private String findAll() throws Exception{
        HashMap<String, User> allUser = DataUtil.findAll();
        return JSON.toJSONString(allUser);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/users/{id}")
    public String findById(@PathVariable String id) throws Exception{
        User user = DataUtil.findUserById(id);
        return JSON.toJSONString(user);
    }

    @PostMapping("/users")
    public String create(@RequestBody User user){
        try {
            DataUtil.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    @PutMapping("/users/{id}")
    public String update(@PathVariable String id,  @RequestBody User user){
        try {
            DataUtil.update(id, user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id){
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }
}
