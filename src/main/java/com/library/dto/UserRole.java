package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    // wywołanie tego enuma na podstawie tego co przychodzi z encji role

    USER(1, "user"),
    ADMIN(2, "admin");

    private int id;
    private String name;

}