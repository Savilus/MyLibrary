package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser {

    private String name;
    private String lastName;
    private String email;
    private Set<UserRole> role;


    public ActiveUser(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public void setRole(UserRole userRole) {
        role.add(userRole);
    }
}
