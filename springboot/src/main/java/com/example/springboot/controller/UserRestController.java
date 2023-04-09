package com.example.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.caseuse.CreateUser;
import com.example.springboot.caseuse.DeleteUser;
import com.example.springboot.caseuse.UpdateUser;
import com.example.springboot.caseuse.interfaces.IGetUser;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController<T> {

    private IGetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUSer;
    private UpdateUser updateUser;
    private UserService userService;

    public UserRestController(IGetUser getUser, CreateUser createUser, DeleteUser deleteUSer, UpdateUser updateUser,
            UserService userService) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUSer = deleteUSer;
        this.updateUser = updateUser;
        this.userService = userService;
    }

    @GetMapping("/lista")
    public Page<User> getAlls(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<User> list = userService.findAll(pageable);
        return list;
    }

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<User>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<T> deleteUser(@PathVariable Long id) {
        deleteUSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return new ResponseEntity<User>(updateUser.update(id, newUser), HttpStatus.CREATED);
    }
}
