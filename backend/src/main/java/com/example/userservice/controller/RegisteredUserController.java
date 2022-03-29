package com.example.userservice.controller;

import com.example.userservice.api.UserServiceApi;
import com.example.userservice.model.RegisteredUser;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class RegisteredUserController implements UserServiceApi {
    @Autowired
    private RegisteredUserService userService;

    @PostMapping("/addUser")
    public RegisteredUser addUser(@RequestBody RegisteredUser registeredUser){
        return userService.addUser(registeredUser);
    }

    @Override
    @GetMapping("/{id}")
    public com.example.userservice.api.RegisteredUser getUser(Integer id) {
        RegisteredUser user = userService.getUser(id);
        return new com.example.userservice.api.RegisteredUser(user.getEmail(), user.getName(), user.getSurname());
    }
}
