package com.harry.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "account_tb1")
public class User implements Serializable {
    @TableId
    private Integer id;
    private String username;
    private Integer age;

    private Integer pid;

    @TableField(exist = false)
    List<Pet> pets;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
