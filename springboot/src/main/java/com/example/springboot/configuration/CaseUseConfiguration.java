package com.example.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.caseuse.GetUserImpl;
import com.example.springboot.caseuse.interfaces.IGetUser;
import com.example.springboot.service.UserService;

@Configuration
public class CaseUseConfiguration {
    @Bean
    IGetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}
