package com.library.controller;

import com.library.ApplicationContext;
import com.library.dto.ActiveUser;
import com.library.dto.UserRole;
import com.library.view.MainMenuView;
import com.library.view.UserRentalBooksView;
import com.library.view.View;

import java.util.Optional;
import java.util.Set;

public class UserRentalBooksController {

    private UserRentalBooksView userRentedBooksView;
    private MainMenuView mainMenuView;
    private final ActiveUser activeUser;

    public UserRentalBooksController() {
        this.userRentedBooksView = new UserRentalBooksView();
        this.mainMenuView = new MainMenuView();
        this.activeUser = ApplicationContext.activeUser();
    }

    public View checkUserRole() {

        Set<UserRole> roles = activeUser.getRole();

        Optional<UserRole> activeUserRole = roles.stream()
                .filter(userRole -> userRole.getName().equals(activeUser.getRole()))
                .findAny();

        if (activeUserRole.equals(UserRole.ADMIN)) {
            userRentedBooksView.adminReturnUserBookView();
        } else if (activeUserRole.equals(UserRole.USER)) {
            userRentedBooksView.showRentedBookListForUser();
        }

        return new MainMenuView();
    }
}
