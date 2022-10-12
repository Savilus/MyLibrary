package com.library.view;

import com.library.controller.NewUserController;
import com.library.dto.NewUserData;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class NewUserView implements View<NewUserData> {

    private final Scanner scanner;
    private final NewUserController newUserController;
    public NewUserView() {
        this.scanner = new Scanner(System.in);
        this.newUserController = new NewUserController();
    }
    @Override
    public void display() {
        newUserController.createNewUser(getData()).display();
    }

    @Override
    public NewUserData getData() {
        return getUserData();
    }

    private String getLoginData() {
        System.out.println("Enter user name:");
        String login = scanner.nextLine();

        return login;
    }


    private NewUserData getUserData() {
        String login = getLoginData();
        // walidacja loginu
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter lastName:");
        String lastname = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        // walidacja email
        System.out.println("Enter city:");
        String city = scanner.nextLine();
        System.out.println("Enter country:");
        String country = scanner.nextLine();
        System.out.println("Enter street:");
        String street = scanner.nextLine();
        System.out.println("Enter zipCode:");
        String zipCode = scanner.nextLine();
        // walidacja zipcode
        System.out.println("Enter buildingNumber:");
        String buildingNumber = scanner.nextLine();
        System.out.println("Enter apartmentNumber:");
        String apartmentNumber = scanner.nextLine();
        // walidacja numeru domu isAvailable

        return new NewUserData(login, password, name,
                lastname, email, city, country, street, zipCode,
                buildingNumber, apartmentNumber);
    }
}
