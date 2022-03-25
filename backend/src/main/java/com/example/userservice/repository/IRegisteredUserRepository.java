package com.example.userservice.repository;

import com.example.userservice.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
}
