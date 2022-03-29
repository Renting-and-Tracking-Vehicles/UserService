package com.example.userservice.controller;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.api.UserServiceApi;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class RegisteredUserController implements UserServiceApi {

    private final RegisteredUserService userService;

    @PostMapping("/addUser")
    public RegisteredUser addUser(@RequestBody RegisteredUser registeredUser){
        return userService.addUser(registeredUser);
    }

    @Override
    @GetMapping("/{id}")
    public RegisteredUser getUser(Integer id) throws UserNotFoundException {
        return userService.getUser(id);
    }
}
