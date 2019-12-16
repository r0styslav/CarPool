package com.symphonysolutions.controller;

import com.symphonysolutions.exception.DuplicateUserException;
import com.symphonysolutions.model.User;
import com.symphonysolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(@RequestBody final User user) {
        ResponseEntity response;
        try {
            response = ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
        } catch (DuplicateUserException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllUsers() {
        ResponseEntity response;
        List<User> users = userService.getAllUsers();
        response = ResponseEntity.status(HttpStatus.OK).body(users);
        return response;
    }
}

