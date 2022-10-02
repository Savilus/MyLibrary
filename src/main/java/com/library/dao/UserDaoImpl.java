package com.library.dao;

import com.library.model.User;
import com.library.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class UserDaoImpl implements UserByLogin, UserById, AddNewUser {

    @Override
    public Optional<User> getUserByLogin(String login) {
        //Tutaj jest caaałe połączenie z bazą danych.
        //Session session;
        //session.find(User.class, id);
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void addNewUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }
}
