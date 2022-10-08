package com.library.view;

import com.library.controller.LoginController;
import com.library.model.User;
import lombok.Getter;

import java.util.Optional;
import java.util.Scanner;

@Getter
public class LoginView implements View {

    private Scanner scanner;
    private final LoginController loginController;

    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
    }

    public String[] getUserLoginAndPassword(){
        String[] loginAndPassword = new String[2];
        System.out.println("Please provide your login.");
        String userLogin = getInformationFromUser();
        loginAndPassword[0] = userLogin;
        System.out.println("Input your password");
        String userPassword = getInformationFromUser();
        loginAndPassword[1] = userPassword;
       return loginAndPassword;
    }
    public void printIfLoginOrPasswordIsWrong() {
        System.out.println("Your login or password is incorrect.");
        System.out.println("Please try again.");

    }
    private String getInformationFromUser() {
        return scanner.nextLine();
    }

    @Override
    public void display() {
        loginController.checkUser().display();
    }
}
