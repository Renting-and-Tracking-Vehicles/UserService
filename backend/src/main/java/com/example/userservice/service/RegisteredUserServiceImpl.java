package com.example.userservice.service;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.model.RegisteredUserEntity;
import com.example.userservice.repository.RegisteredUserRepository;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisteredUserServiceImpl implements RegisteredUserService {

    private final RegisteredUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public RegisteredUserEntity addUser(RegisteredUserEntity registeredUser) {
        return  userRepository.save(registeredUser);
    }

    @Override
    public RegisteredUser getUser(Integer id) {
        RegisteredUserEntity user = userRepository.findById(id).get();
        return modelMapper.map(user, RegisteredUser.class);
    }
}
