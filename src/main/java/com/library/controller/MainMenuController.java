package com.library.controller;

import com.library.dto.MainMenuOption;
import com.library.service.MainMenuService;
import com.library.view.AvailableBooksView;
import com.library.view.MainMenuView;
import com.library.view.NewUserView;
import com.library.view.View;

import java.util.List;

public class MainMenuController {

    private MainMenuService mainMenuService;

    public List<MainMenuOption> getUserOptions() {
        return mainMenuService.getMainMenuOptionsForActiveUser();

    }

    public View selectOption(MainMenuOption mainMenuOption) {
        switch (mainMenuOption) {
            case ADD_NEW_USER: return new NewUserView();
            case SHOW_AVAILABLE_BOOKS: return new AvailableBooksView();
            default: return new MainMenuView();
        }
    }
}

