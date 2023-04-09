package com.example.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPojo {
    private String email;
    private String password;
    private int age;
}
