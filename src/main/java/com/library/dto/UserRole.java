package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum UserRole {

    USER(1, "user"),
    ADMIN(2, "admin");

    private int id;
    private String name;

    public static Optional<UserRole> find(String name) {
        return Arrays.stream(values())
                .filter(userRole -> name.equals(userRole.getName()))
                .findAny();
    }

}
