package com.library.dao;

import com.library.model.User;
import com.library.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class UserDaoImpl implements UserByLogin, UserById {

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<User> user = session.createQuery("SELECT u FROM User U WHERE login = :login", User.class)
                .setParameter("login", login)
                .stream()
                .findAny();
        session.close();
        return user;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.empty();
    }

}
