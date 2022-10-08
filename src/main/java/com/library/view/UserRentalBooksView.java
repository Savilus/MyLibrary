package com.library.view;

import com.library.controller.UserRentalBooksController;

import java.util.Scanner;

public class UserRentalBooksView implements View {

    private final UserRentalBooksController userRentedBooksController;
    private Scanner scanner;

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_WHITE = "\u001B[37m";


    public UserRentalBooksView() {
        this.userRentedBooksController = new UserRentalBooksController();

        this.scanner = new Scanner(System.in);
    }

    public void showRentedBookListForUser() {

        System.out.println("Your rented books: ");
        // lista z wypożyczonymi książkami
        String userKeyPress;
        do {
            System.out.println(ANSI_WHITE + "For exit please press 1" + ANSI_RESET);
            userKeyPress = scanner.nextLine();
        } while (!userKeyPress.equals("1"));
        new MainMenuView();
    }

    public void showRentedBookListForAdmin() {

        System.out.println("List of user rented books");
        // lista - lepsza będzie linked lista
        System.out.println("To return book do something");
        // logika usunięcia książki
        System.out.println(ANSI_WHITE + "Are you sure you want return this book?" + ANSI_RESET);
        System.out.println("Enter 1 if yes.");
        System.out.println("Enter 2 if no.");
        System.out.println("For Exit press 'E' ");
        String adminPressKey = scanner.nextLine();
        switch (adminPressKey) {
            case "1":
                System.out.println(ANSI_GREEN + "Book was successfully returned" + ANSI_RESET);
                // usunięcie książki z listy
                showRentedBookListForAdmin();
                break;
            case "2":
                System.out.println(ANSI_RED + "You didn't returned the book" + ANSI_RESET);
                showRentedBookListForAdmin();
                break;
            case "e":
            case "E":
                new MainMenuView();
                break;
            default:
                System.out.println("Please enter number [1] or [2]! Press E to go to Main Menu ");
                showRentedBookListForAdmin();
        }
    }

    @Override
    public void display() {
        userRentedBooksController.checkUserRole().display();
    }
}
