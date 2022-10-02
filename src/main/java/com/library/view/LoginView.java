package com.library.view;

import com.library.controller.LoginController;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class LoginView implements View {

    private Scanner scanner;
    private final LoginController loginController;

    // dodać konstruktor z dodatkową wiadomością
    // jeżeli jest złe hasło, optional z dodatkową wiadomością
    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
    }

    public String printLoginIntoLibrary() {
        System.out.println("Please provide your login.");
        String userLogin = getInformationFromUser();
        return userLogin;
    }

    public String printPasswordIntoLibrary(){
        System.out.println("Input your password");
        String userPassword = getInformationFromUser();
        return userPassword;
    }

    public void printIfLoginOrPasswordIsWrong(){
        System.out.println("Your login or password is incorrect.");
        System.out.println("Please try again.");
        printLoginIntoLibrary();
        printPasswordIntoLibrary();

    }
    private String getInformationFromUser() {
        return scanner.nextLine();
    }

    @Override
    public void display() {
        printLoginIntoLibrary();
        printPasswordIntoLibrary();
        loginController.checkUser().display();
    }
}
