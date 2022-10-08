package com.library.dao;

import com.library.model.Role;

public interface RoleByName {
    Role findByName(String name);
}
