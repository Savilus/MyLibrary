package com.library.service;

import com.library.dao.UserByLogin;
import com.library.dao.UserDaoImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserByLogin userDao;

    public LoginServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean hasProvidedCorrectLoginData(String login, String password) {
        return userDao.getUserByLogin(login)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

}
