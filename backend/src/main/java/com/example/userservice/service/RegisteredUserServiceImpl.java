package com.example.userservice.service;

import com.example.userservice.model.RegisteredUser;
import com.example.userservice.repository.IRegisteredUserRepository;
import com.example.userservice.service.interfaces.IRegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserServiceImpl implements IRegisteredUserService {
    @Autowired
    private IRegisteredUserRepository userRepository;

    @Override
    public RegisteredUser addUser(RegisteredUser registeredUser) {
        return  userRepository.save(registeredUser);
    }
}
