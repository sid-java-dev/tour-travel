package com.airbnb.controller;

import com.airbnb.entity.PropertyUser;
import com.airbnb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/add")
    public ResponseEntity<PropertyUser>addUser(@RequestBody PropertyUser user) {
        PropertyUser propertyUser = userService.addUser(user);
        return new ResponseEntity<>(propertyUser, HttpStatus.CREATED);
    }
}
