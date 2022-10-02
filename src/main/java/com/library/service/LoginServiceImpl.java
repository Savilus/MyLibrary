package com.library.service;

import com.library.dao.UserByLogin;
import com.library.dao.UserDaoImpl;
import com.library.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class LoginServiceImpl implements UserService {

    private final UserByLogin userDao;


    public LoginServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean hasProvidedCorrectLoginData(String login, String password) {
        return userDao.getUserByLogin(login)
                .map(user -> checkUserPassword(user, password))
                .orElse(false);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }

    private boolean checkUserPassword(User user, String providedPassword) {
        return user.getPassword().equals(providedPassword);
    }



}
