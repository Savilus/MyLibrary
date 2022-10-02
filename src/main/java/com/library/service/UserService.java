package com.library.service;

import com.library.model.User;

import java.util.Optional;

public interface UserService {

    boolean hasProvidedCorrectLoginData(String login, String password);
    Optional<User> getUserByLogin(String login);

}
