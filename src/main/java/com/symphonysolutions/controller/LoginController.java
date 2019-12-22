package com.symphonysolutions.controller;

import com.symphonysolutions.exception.DuplicateUserException;
import com.symphonysolutions.model.User;
import com.symphonysolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody final User user) {
        ResponseEntity response;
        User savedUser = userService.findUserByEmail(user.getEmail());
        if (savedUser != null) {
            if (savedUser.getPassword().equals(user.getPassword()))
                response = ResponseEntity.status(HttpStatus.OK).body(savedUser);
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return response;
    }

    @PostMapping(value = "/register")
    public ResponseEntity addUser(@RequestBody final User user) {
        ResponseEntity response;
        try {
            response = ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
        } catch (DuplicateUserException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return response;
    }
}
