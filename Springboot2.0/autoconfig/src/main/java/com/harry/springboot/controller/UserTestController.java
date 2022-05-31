package com.harry.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.harry.springboot.bean.User;
import com.harry.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
public class UserTestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public long getUserCount() throws Exception {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tb1", Long.class);
        log.info("记录总数：{}", aLong);
        return aLong;
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user) {

        boolean save = userService.save(user);
        return save;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/userAll")
    public Page<User> getUserAll(){
        int pageNumber = 0;
        // 构造分页参数
        Page<User> page = new Page<User>(pageNumber, 10);
        // 调用page分页
        Page<User> userPage = userService.page(page, null);
        // 调用page进行分页
        return userPage;
    }
}
