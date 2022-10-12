package com.library.service;

import com.library.dao.UserByLogin;
import com.library.dao.UserDaoImpl;
import com.library.dto.UserLoginData;
import com.library.dto.UserRole;
import com.library.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;


@Getter
public class UserServiceImpl implements UserService {

    private final UserByLogin userDao;


    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    public UserServiceImpl(UserByLogin userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean hasProvidedCorrectLoginData(UserLoginData userLoginData) {
        return userDao.getUserByLogin(userLoginData.getLogin())
                .map(user -> user.getPassword().equals(userLoginData.getPassword()))
                .orElse(false);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

}
