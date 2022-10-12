package com.library.view;

import com.library.controller.LoginController;
import com.library.dto.UserLoginData;
import com.library.model.User;
import com.library.service.UserServiceImpl;
import com.library.util.GetInput;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


class LoginViewTest {

    private final static String USER_LOGIN = "userLogin";
    private final static String USER_PASSWORD = "userPassword";
    public static final File USER_INPUT = new File("src/test/resources/userLoginPassword.txt");

    private final UserLoginData userLoginData = new UserLoginData(USER_LOGIN,USER_PASSWORD);


    @Test
    void shouldReturnUserLoginAndPassword() throws FileNotFoundException {

        LoginView loginView = new LoginView(
                new Scanner(USER_INPUT),
                new LoginController(
                        new UserServiceImpl(
                                login -> Optional.of(User.builder()
                                        .login(USER_LOGIN)
                                        .password(USER_PASSWORD)
                                        .build())
                        )),
                Optional.empty());

        UserLoginData data = loginView.getData();

        assertThat(data).isEqualTo(userLoginData);
    }
}