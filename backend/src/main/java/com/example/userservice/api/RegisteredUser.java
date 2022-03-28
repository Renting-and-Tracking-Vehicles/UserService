package com.example.userservice.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor@AllArgsConstructor
public class RegisteredUser {
    private String email;
    private String name;
    private String surname;
}
