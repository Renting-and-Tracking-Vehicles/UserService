package com.example.userservice.service;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.RegisteredUserEntity;
import com.example.userservice.model.Role;
import com.example.userservice.repository.RegisteredUserRepository;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegisteredUserServiceImpl implements RegisteredUserService, UserDetailsService {

    private final RegisteredUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public RegisteredUser addUser(RegisteredUser registeredUser) {
        RegisteredUserEntity registeredUserEntity = modelMapper.map(registeredUser, RegisteredUserEntity.class);
        registeredUserEntity.setRoles(roleRepository.findByName(registeredUser.getRole()));
        registeredUserEntity.setPassword(passwordEncoder.encode(registeredUser.getPassword()));
        userRepository.save(registeredUserEntity);
        return registeredUser;

    }

    @Override
    public RegisteredUser getUser(Integer id) throws UserNotFoundException {
        Optional<RegisteredUserEntity> registeredUser = userRepository.findById(id);
        if(registeredUser.isPresent())
            return modelMapper.map(registeredUser.get(), RegisteredUser.class);

        throw new UserNotFoundException();
    }

    @Override
    public List<RegisteredUser> findAll() {
        return userRepository.findAll().stream().map(i -> modelMapper.map(i, RegisteredUser.class)).collect(Collectors.toList());

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<RegisteredUserEntity> registeredUserEntity = userRepository.findByEmail(email);
        if(registeredUserEntity.isPresent()){
            return modelMapper.map(registeredUserEntity.get(), RegisteredUserEntity.class);
        }
        throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
    }
}
