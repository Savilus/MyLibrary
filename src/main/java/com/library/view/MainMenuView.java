package com.library.view;

import com.library.controller.MainMenuController;
import com.library.dto.MainMenuOption;
import com.library.util.DisplayMapUtil;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMenuView implements View<MainMenuOption> {

    private MainMenuController mainMenuController;
    private DisplayMapUtil<MainMenuOption> mainMenuOptionDisplayMapUtil;
    private Scanner scanner = new Scanner(System.in);

    public MainMenuView() {
        this.mainMenuController = new MainMenuController();
    }

    public MainMenuView(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public MainMenuOption getMainMenuOption() {
        List<MainMenuOption> userOptions = mainMenuController.getUserOptions();
        Map<Integer, MainMenuOption> optionsMap = mainMenuOptionDisplayMapUtil.displayMap(userOptions);
        optionsMap.forEach((optionId, mainMenuOption) -> System.out.println(optionId + ". " + mainMenuOption));

        String userChoose = scanner.nextLine();
        if (mainMenuOptionDisplayMapUtil.canBeSelected(optionsMap, userChoose)) {
            return optionsMap.get(Integer.parseInt(userChoose));
        }
        return getMainMenuOption();
    }

    @Override
    public void display() {
        mainMenuController.selectOption(getData()).display();
    }

    @Override
    public MainMenuOption getData() {
        return getMainMenuOption();
    }
}
