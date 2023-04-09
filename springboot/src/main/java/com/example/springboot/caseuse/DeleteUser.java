package com.example.springboot.caseuse;

import org.springframework.stereotype.Component;

import com.example.springboot.service.UserService;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {
        userService.delete(id);
    }

}
