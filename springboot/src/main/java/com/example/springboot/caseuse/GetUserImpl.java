package com.example.springboot.caseuse;

import java.util.List;

import com.example.springboot.caseuse.interfaces.IGetUser;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

public class GetUserImpl implements IGetUser {

    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

}
