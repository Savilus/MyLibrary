package com.library.dao;

import com.library.model.User;

import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> getUserByLogin(String login) {
        //Tutaj jest caaałe połączenie z bazą danych.
        //Session session;
        //session.find(User.class, id);
        return null;
    }

}
