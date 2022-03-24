package com.example.userservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public User(String email, String password, String name, String surname, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}
