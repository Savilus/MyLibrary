package com.library.service;

import com.library.dao.UserDao;
import com.library.dao.UserDaoImpl;
import com.library.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserDao userDao;

    public LoginServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean hasProvidedCorrectLoginData(String login, String password) {

        return null;
    }

}
