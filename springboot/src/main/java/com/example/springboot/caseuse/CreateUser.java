package com.example.springboot.caseuse;

import org.springframework.stereotype.Component;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
