package com.library.view;

import com.library.util.GetInput;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;

class LoginViewTest  {

    private final static String USER_LOGIN = "userLogin";
    private final static String USER_PASSWORD = "userPassword";
    public static final File USER_INPUT = new File("src/test/resources/userLoginPassword.txt");
    private final static String[] EXPECTED_RESULT = {USER_LOGIN, USER_PASSWORD};


    @Test
    void shouldReturnUserLoginAndPassword() throws FileNotFoundException {
        GetInput loginAndPassword = new GetInput(new Scanner(USER_INPUT));
        String userLogin = loginAndPassword.getInput();
        String userPassword = loginAndPassword.getInput();
        String[] loginAndPasswordProvidedByUser = {userLogin, userPassword};


        org.junit.Assert.assertArrayEquals(loginAndPasswordProvidedByUser, EXPECTED_RESULT);
    }
}