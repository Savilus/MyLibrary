package com.library.controller;

import com.library.ApplicationContext;
import com.library.model.User;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;
import com.library.view.LoginView;
import com.library.view.MainMenuView;
import com.library.view.View;

import java.util.Optional;

public class LoginController {

    private LoginView loginView;
    private UserService loginService;
    private MainMenuView mainMenuView;

    public LoginController() {
        this.loginView = new LoginView();
        this.loginService = new UserServiceImpl();
        this.mainMenuView = new MainMenuView();
    }

    public View checkUser() {
        String[] userLoginAndPassword = loginView.getUserLoginAndPassword();
        String loginProvidedByUser = userLoginAndPassword[0];
        String passwordProvidedByUser = userLoginAndPassword[1];

        boolean checkLoginAndPassword = loginService.hasProvidedCorrectLoginData(loginProvidedByUser, passwordProvidedByUser);

        if (!checkLoginAndPassword) {
            loginView.printIfLoginOrPasswordIsWrong();
            loginView.display();
        } else {
            Optional<User> user = loginService.getUserByLogin(loginProvidedByUser);

            ApplicationContext applicationContext = new ApplicationContext();
            applicationContext.setActiveUser(user.get().getLogin());
        }

        return new MainMenuView();
    }

}
