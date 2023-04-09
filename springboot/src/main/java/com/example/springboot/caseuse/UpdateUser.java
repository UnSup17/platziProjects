package com.example.springboot.caseuse;

import org.springframework.stereotype.Component;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(Long id, User newUser) {
        return this.userService.update(id, newUser);
    }

}
