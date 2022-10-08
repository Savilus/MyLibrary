package com.library.controller;

import com.library.ApplicationContext;
import com.library.dto.ActiveUser;
import com.library.dto.UserRole;
import com.library.view.MainMenuView;
import com.library.view.UserRentalBooksView;
import com.library.view.View;

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

    public View checkUserRole(){

        Set<UserRole> roles = activeUser.getRole();

        for (UserRole role: roles) {
            if(role.equals(UserRole.ADMIN)){
                userRentedBooksView.showRentedBookListForAdmin();
            } else if (role.equals(UserRole.USER)) {
                userRentedBooksView.showRentedBookListForUser();
            }
        }
        return new MainMenuView();
    }
}
