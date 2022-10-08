package com.library;

import com.library.dto.ActiveUser;
import com.library.model.Role;
import com.library.model.User;
import com.library.service.RolesService;
import com.library.service.RolesServiceImpl;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

public class ApplicationContext {


    private final UserService loggedIn = new UserServiceImpl();
    private static final ActiveUser ACTIVE_USER = new ActiveUser();

    public static ActiveUser activeUser() {
        return ACTIVE_USER;
    }

    public void setActiveUser(String login) {

        Optional<User> loggedInUser = loggedIn.getUserByLogin(login);
        ACTIVE_USER.setName(loggedInUser.get().getName());
        ACTIVE_USER.setLastName(loggedInUser.get().getLastName());
        ACTIVE_USER.setEmail(loggedInUser.get().getEmail());

        List<Role> roles = loggedInUser.get().getRoles();
        RolesService rolesService = new RolesServiceImpl();
        for (Role role : roles) {
            String name = role.getName();
            rolesService.setRolesFromDb(name);
        }
    }
}
