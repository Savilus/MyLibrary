package com.library.service;

import com.library.dto.UserLoginData;
import com.library.model.User;

import java.util.Optional;

public interface UserService {

    boolean hasProvidedCorrectLoginData(UserLoginData userLoginData);

    Optional<User> getUserByLogin(String login);

}
