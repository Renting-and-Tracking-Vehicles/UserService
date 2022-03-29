package com.example.userservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "registered_user")
public class RegisteredUserEntity {
    @Id
    @SequenceGenerator(name = "userSeqGen", sequenceName = "userSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @Column(name="email", unique=true, nullable=false)
    private String email;
    @Column(name="password", nullable=false)
    private String password;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="surname", nullable=false)
    private String surname;
    @Column(name="phone", nullable=false)
    private String phone;

    public RegisteredUserEntity(String email, String password, String name, String surname, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}
