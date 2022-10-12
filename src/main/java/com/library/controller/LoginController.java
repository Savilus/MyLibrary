package com.library.controller;

import com.library.ApplicationContext;
import com.library.dto.UserLoginData;
import com.library.model.User;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;
import com.library.view.LoginView;
import com.library.view.MainMenuView;
import com.library.view.View;

import java.util.Optional;

public class LoginController {

    private UserService loginService;

    public LoginController() {
        this.loginService = new UserServiceImpl();
    }

    public LoginController(UserService loginService) {
        this.loginService = loginService;
    }

    public View<?> checkUser(UserLoginData userLoginData) {


        boolean checkLoginAndPassword = loginService.hasProvidedCorrectLoginData(userLoginData);

        if (!checkLoginAndPassword) {
            return new LoginView(Optional.of("Your login or password is incorrect."));
        }

        Optional<User> user = loginService.getUserByLogin(userLoginData.getLogin());
        ApplicationContext.setActiveUser(user.get());
        return new MainMenuView();
    }

}

