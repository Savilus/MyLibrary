package com.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ActiveUser {

    private String name;
    private String lastName;
    private String email;
    private Set<UserRole> role;


}
