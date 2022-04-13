package com.example.userservice.service.interfaces;

import com.example.userservice.model.Role;

public interface RoleService {
    Role findByName(String name);
}
