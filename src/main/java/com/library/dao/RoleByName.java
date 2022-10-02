package com.library.dao;

import com.library.model.Role;

import java.util.Optional;

public interface RoleByName {
    Role findByName(String name);
}
