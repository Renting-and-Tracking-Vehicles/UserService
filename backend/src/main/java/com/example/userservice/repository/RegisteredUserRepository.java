package com.example.userservice.repository;

import com.example.userservice.model.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, Integer> {
    Optional<RegisteredUserEntity> findByEmail(String email);
}
