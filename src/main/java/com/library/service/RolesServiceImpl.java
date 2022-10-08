package com.library.service;

import com.library.ApplicationContext;
import com.library.dto.UserRole;

public class RolesServiceImpl implements RolesService {

    @Override
    public void setRolesFromDb(String name) {
        String admin = UserRole.ADMIN.getName();
        String user = UserRole.USER.getName();

        if(name.equals(admin)){
            UserRole userRole = UserRole.ADMIN;
            ApplicationContext.activeUser().setRole(userRole);

        } else if (name.equals(user)) {
            UserRole userRole = UserRole.USER;
            ApplicationContext.activeUser().setRole(userRole);
        }
    }
}

