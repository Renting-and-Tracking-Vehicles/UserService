package com.example.userservice.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor@AllArgsConstructor
@Builder
public class RegisteredUser {
    private String email;
    private String name;
    private String surname;
    private String password;
    private String phone;
    private String role;

}
