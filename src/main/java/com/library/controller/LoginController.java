package com.library.controller;

import com.library.service.LoginService;
import com.library.service.LoginServiceImpl;
import com.library.view.LoginView;
import com.library.view.View;

public class LoginController {

    private LoginView loginView;
    private LoginService loginService;

    public LoginController() {
        this.loginView = new LoginView();
        this.loginService = new LoginServiceImpl();
    }

    public View checkUser() {

        String loginProvidedByUser = loginView.printLoginIntoLibrary();
        String passwordProvidedByUser = loginView.printPasswordIntoLibrary();
        boolean checkLoginAndPassword = loginService.hasProvidedCorrectLoginData(loginProvidedByUser, passwordProvidedByUser);

        if (!checkLoginAndPassword) {
           loginView.display();
        } else {


        }

        return null;
    }
}
