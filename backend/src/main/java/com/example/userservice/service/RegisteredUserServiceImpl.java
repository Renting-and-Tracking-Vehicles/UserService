package com.example.userservice.service;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.RegisteredUserEntity;
import com.example.userservice.repository.RegisteredUserRepository;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegisteredUserServiceImpl implements RegisteredUserService {

    private final RegisteredUserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public RegisteredUser addUser(RegisteredUser registeredUser) {
        RegisteredUserEntity registeredUserEntity = modelMapper.map(registeredUser, RegisteredUserEntity.class);
        userRepository.save(registeredUserEntity);
        return registeredUser;
    }

    @Override
    public RegisteredUser getUser(Integer id) throws UserNotFoundException {
        RegisteredUserEntity userEntity = userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
        if(userEntity.equals(null))
            throw new UserNotFoundException();

        return modelMapper.map(userEntity, RegisteredUser.class);
    }

    @Override
    public List<RegisteredUser> findAll() {
        return userRepository.findAll().stream().map(i -> modelMapper.map(i, RegisteredUser.class)).collect(Collectors.toList());
    }
}
