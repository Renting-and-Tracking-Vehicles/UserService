package com.example.userservice.service;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.RegisteredUserEntity;
import com.example.userservice.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.userservice.constants.RegisteredUserConstants.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RegisteredUserServiceTest {
    @Mock
    private RegisteredUserRepository registeredUserRepositoryMock;

    @Mock
    private RegisteredUserEntity registeredUserEntityMock;

    @InjectMocks
    private RegisteredUserServiceImpl registeredUserService;

    @Test
    public void testAddUser() {
        RegisteredUser registeredUser = RegisteredUser.builder().email(EMAIL).name(NAME).surname(SURNAME).build();

        when(registeredUserRepositoryMock.save(registeredUserEntityMock)).thenReturn(registeredUserEntityMock);

        RegisteredUser newUser = registeredUserService.addUser(registeredUser);

        Assert.assertEquals(newUser, registeredUser);
    }

    @Test
    public void testGetUser() throws UserNotFoundException {
        when(registeredUserRepositoryMock.findById(DB_ID)).thenReturn(Optional.of(registeredUserEntityMock));

        RegisteredUser registeredUserEntity = registeredUserService.getUser(DB_ID);

        Assert.assertEquals(registeredUserEntity.getEmail(), registeredUserEntityMock.getEmail());
    }

    @Test
    public void testGetUserException() {
        Assert.assertThrows(UserNotFoundException.class, () -> {
            when(registeredUserRepositoryMock.findById(DB_FALSE_ID)).thenReturn(Optional.empty());
            registeredUserService.getUser(DB_FALSE_ID);
        });
    }

    @Test
    public void testFindAll() {
        when(registeredUserRepositoryMock.findAll()).thenReturn(Arrays.asList(RegisteredUserEntity.builder().email(EMAIL).name(NAME).password(PASSWORD).surname(SURNAME).phone(PHONE).build()));

        List<RegisteredUser> registeredUsers = registeredUserService.findAll();

        assertThat(registeredUsers).hasSize(1);
        Assert.assertEquals(registeredUsers.get(0).getEmail(), EMAIL);
    }
}
