package com.library.controller;

import com.library.dto.UserAvailableBooksOption;
import com.library.service.AvailableBooksService;
import com.library.view.AvailableBooksView;
import com.library.view.MainMenuView;
import com.library.view.View;

import java.util.List;

public class AvailableBooksController {

    private AvailableBooksService availableBooksService;
    private AvailableBooksView availableBooksView = new AvailableBooksView();

    public View selectOption(UserAvailableBooksOption userOption) {
        switch (userOption) {
            case ALL_AVAILABLE_BOOK:
                new MainMenuView();
            case AVAILABLE_BOOK_BY_CATEGORY:
                new MainMenuView();
            case AVAILABLE_BOOK_BY_AUTHOR:
                new MainMenuView();
            default:
                return new MainMenuView();
        }
    }

    public List<UserAvailableBooksOption> getUserOptions() {
        return availableBooksService.getUserAvailableBooksOptions();

    }
}

