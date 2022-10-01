package com.library.dao;

import com.library.model.User;

import java.util.Optional;

public interface UserById {

    Optional<User> getUserById(Integer id);

}
