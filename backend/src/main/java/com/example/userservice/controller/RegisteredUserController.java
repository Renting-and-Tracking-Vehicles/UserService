package com.example.userservice.controller;

import com.example.userservice.model.RegisteredUser;
import com.example.userservice.service.interfaces.IRegisteredUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class RegisteredUserController {
    @Autowired
    private IRegisteredUserService userService;

    @PostMapping("/addUser")
    public RegisteredUser addUser(@RequestBody RegisteredUser registeredUser){
        return userService.addUser(registeredUser);
    }

}
