package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.Immutable;


@Immutable
@Value
@AllArgsConstructor
public class UserLoginData {

    private final String login;
    private final String password;


}
