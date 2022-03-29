package com.example.userservice.repository;

import com.example.userservice.model.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, Integer> {
}
