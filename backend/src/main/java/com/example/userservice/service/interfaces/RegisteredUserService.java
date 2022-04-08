package com.example.userservice.service.interfaces;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.RegisteredUserEntity;

import java.util.List;

public interface RegisteredUserService {
    RegisteredUser addUser(RegisteredUser registeredUser);

    RegisteredUser getUser(Integer id) throws UserNotFoundException;

    List<RegisteredUser> findAll();

    RegisteredUser getByEmail(String email);

    RegisteredUser editUser(RegisteredUser registeredUser);
}
