package com.library;

import com.library.dto.ActiveUser;
import com.library.dto.UserRole;
import com.library.model.Role;
import com.library.model.User;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ApplicationContext {

    private static ActiveUser ACTIVE_USER;

    public static ActiveUser activeUser() {
        return ACTIVE_USER;
    }

    public static void setActiveUser(User user) {
        ACTIVE_USER = new ActiveUser(
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                mapToUserRoles(user.getRoles()));
    }

    private static Set<UserRole> mapToUserRoles(List<Role> roles) {
        return roles.stream()
                .flatMap(role -> UserRole.find(role.getName()).stream())
                .collect(toSet());

    }
}
