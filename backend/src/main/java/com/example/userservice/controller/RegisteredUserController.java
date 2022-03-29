package com.example.userservice.controller;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.api.UserServiceApi;
import com.example.userservice.config.ModelMapperConfig;
import com.example.userservice.model.RegisteredUserEntity;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class RegisteredUserController implements UserServiceApi {

    private final RegisteredUserService userService;

    @PostMapping("/addUser")
    public RegisteredUserEntity addUser(@RequestBody RegisteredUserEntity registeredUser){
        return userService.addUser(registeredUser);
    }

    @Override
    @GetMapping("/{id}")
    public RegisteredUser getUser(Integer id) {
        return userService.getUser(id);
    }
}
