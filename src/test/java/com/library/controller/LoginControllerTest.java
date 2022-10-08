package com.library.controller;

import com.library.model.User;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;
import com.library.view.LoginView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest{

    private final String USER_LOGIN = "correctLogin";
    private final String USER_PASSWORD = "correctPassword";
    private final String WRONG_USER_LOGIN = "wrongLogin";
    private final String WRONG_USER_PASSWORD = "wrongPassword";
    private final User testUser = new User(
            USER_LOGIN,
            USER_PASSWORD);



    private final UserService userService = new UserServiceImpl(

    );

    @Test
    void checkUserWithCorrectLoginAndPassword() {
        // given
        testUser.setLogin(USER_LOGIN);
        testUser.setPassword(USER_PASSWORD);
        // when


        //then

    }
}