package com.example.userservice.service;

import com.example.userservice.model.RegisteredUser;
import com.example.userservice.repository.IRegisteredUserRepository;
import com.example.userservice.service.interfaces.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {
    @Autowired
    private IRegisteredUserRepository userRepository;

    @Override
    public RegisteredUser addUser(RegisteredUser registeredUser) {
        return  userRepository.save(registeredUser);
    }

    @Override
    public RegisteredUser getUser(Integer id) {
        return userRepository.getById(id);
    }
}
