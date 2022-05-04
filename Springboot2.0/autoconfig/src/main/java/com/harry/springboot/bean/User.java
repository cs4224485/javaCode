package com.harry.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private String username;
    private int age;
    private Pet pet;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
