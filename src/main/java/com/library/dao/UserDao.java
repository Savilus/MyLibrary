package com.library.dao;

import com.library.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByLogin(String login);

}
