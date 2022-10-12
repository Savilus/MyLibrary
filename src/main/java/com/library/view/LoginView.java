package com.library.view;

import com.library.controller.LoginController;
import com.library.dto.UserLoginData;
import lombok.Getter;

import java.util.Optional;
import java.util.Scanner;

@Getter
public class LoginView implements View<UserLoginData> {

    private Scanner scanner;
    private final LoginController loginController;
    private Optional<String> message;

    public LoginView(Optional<String> message) {
        this.message = message;
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
    }

    public LoginView(Scanner scanner, LoginController loginController, Optional<String> message) {
        this.scanner = scanner;
        this.loginController = loginController;
        this.message = message;
    }

    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
    }


    private UserLoginData getUserLoginAndPassword() {

        System.out.println("Please provide your login.");
        String userLogin = getInformationFromUser();
        System.out.println("Input your password");
        String userPassword = getInformationFromUser();
        return new UserLoginData(userLogin, userPassword);
    }

    private String getInformationFromUser() {
        return scanner.nextLine();
    }

    @Override
    public void display() {
        loginController.checkUser(getData()).display();
    }
    @Override
    public UserLoginData getData() {
        return getUserLoginAndPassword();
    }
}
