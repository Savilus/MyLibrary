package com.library.service;

import com.library.dto.MainMenuOption;

import java.util.Arrays;
import java.util.List;

import static com.library.ApplicationContext.activeUser;
import static java.util.stream.Collectors.toList;

public class MainMenuService {

    public List<MainMenuOption> getMainMenuOptionsForActiveUser() {
        return Arrays.stream(MainMenuOption.values())
                .filter(mainMenuOption ->
                        activeUser()
                                .getRole()
                                .contains(mainMenuOption.getUserRole()))
                .collect(toList());
    }


}
