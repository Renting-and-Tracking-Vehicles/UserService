package com.example.userservice.service.interfaces;

import com.example.userservice.model.RegisteredUser;

public interface RegisteredUserService {
    RegisteredUser addUser(RegisteredUser registeredUser);

    RegisteredUser getUser(Integer id);
}
