package com.library.dao;

import com.library.model.User;

import java.util.Optional;

public interface UserByLogin {

    Optional<User> getUserByLogin(String login);

}
