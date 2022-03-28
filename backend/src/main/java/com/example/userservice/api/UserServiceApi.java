package com.example.userservice.api;

import com.example.userservice.model.RegisteredUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("users")
public interface UserServiceApi {

    @GetMapping("/{id}")
    public RegisteredUser getUser(@PathVariable Integer id);

}
