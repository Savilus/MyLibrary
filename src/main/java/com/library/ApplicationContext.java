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
    private final static ActiveUser activeUser = new ActiveUser();

    public static ActiveUser activeUser() {
        return activeUser;
    }

    public void setActiveUser(String login) {

        Optional<User> loggedInUser = loggedIn.getUserByLogin(login);
        activeUser.setName(loggedInUser.get().getName());
        activeUser.setLastName(loggedInUser.get().getLastName());
        activeUser.setEmail(loggedInUser.get().getEmail());

        List<Role> roles = loggedInUser.get().getRoles();
        RolesService rolesService = new RolesServiceImpl();
        for (Role role : roles) {
            String name = role.getName();
            rolesService.setRolesFromDb(name);
        }
    }
}
