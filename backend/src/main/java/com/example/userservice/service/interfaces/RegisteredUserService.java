package com.example.userservice.service.interfaces;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.exception.UserNotFoundException;

public interface RegisteredUserService {
    RegisteredUser addUser(RegisteredUser registeredUser);

    RegisteredUser getUser(Integer id) throws UserNotFoundException;
}
