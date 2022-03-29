package com.example.userservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceApi {

    @GetMapping("/users/{id}")
    public RegisteredUser getUser(@PathVariable Integer id);

}
