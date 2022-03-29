package com.example.userservice.service.interfaces;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.model.RegisteredUserEntity;

public interface RegisteredUserService {
    RegisteredUserEntity addUser(RegisteredUserEntity registeredUser);

    RegisteredUser getUser(Integer id);
}
