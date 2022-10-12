package com.library.view;

import com.library.controller.AvailableBooksController;
import com.library.dto.AvailableBook;
import com.library.dto.UserAvailableBooksOption;
import com.library.model.Category;
import com.library.service.AvailableBooksService;
import com.library.util.DisplayMapUtil;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AvailableBooksView implements View<UserAvailableBooksOption> {

    private final AvailableBooksController availableBooksController;
    private final AvailableBooksService availableBooksService;
    private Scanner scanner = new Scanner(System.in);
    private DisplayMapUtil<UserAvailableBooksOption> userAvailableBooksOptionDisplayMapUtil;

    private DisplayMapUtil<AvailableBook> availableBookDisplayMapUtil;



    public AvailableBooksView(AvailableBooksController availableBooksController, AvailableBooksService availableBooksService) {
        this.availableBooksController = availableBooksController;
        this.availableBooksService = availableBooksService;
    }

    public AvailableBooksView() {

        this.availableBooksController = new AvailableBooksController();
        this.availableBooksService = new AvailableBooksService();
    }

    private UserAvailableBooksOption getAvailableListsForUsers() {
        List<UserAvailableBooksOption> userOptions = availableBooksController.getUserOptions();
        Map<Integer, UserAvailableBooksOption> optionsMap = userAvailableBooksOptionDisplayMapUtil.displayMap(userOptions);
        optionsMap.forEach((optionID, availableBooksOption) -> System.out.println(optionID + ". " + availableBooksOption));

        System.out.println("Jaka listę książek chcesz wyświetlić?");
        String userChoice = scanner.nextLine();
        if(userAvailableBooksOptionDisplayMapUtil.canBeSelected(optionsMap, userChoice)){
            return optionsMap.get(Integer.parseInt(userChoice));
        }
        return getAvailableListsForUsers();
    }

    private void useAllAvailableBooks(){
        List<AvailableBook> availableBooks = availableBooksService.getAvailableBooks();
        Map<Integer, AvailableBook> showAvailableBooksForUser = availableBookDisplayMapUtil.displayMap(availableBooks);
        showAvailableBooksForUser.forEach((optionId, availableBook) -> System.out.println(optionId + ". " + availableBook));
    }

    private void userAvailableBooksByCategory(){
        System.out.println("Podaj po jakiej kategori chcesz szukać.");
        String categoryName = scanner.nextLine();
        List<AvailableBook> availableBooks = availableBooksService.getAvailableBooksByCategory(categoryName);
        Map<Integer, AvailableBook> showAvailableBooksForUser = availableBookDisplayMapUtil.displayMap(availableBooks);
        showAvailableBooksForUser.forEach((optionId, availableBook) -> System.out.println(optionId + ". " + availableBook));
    }


    @Override
    public void display() {
        getAvailableListsForUsers();
        }

    @Override
    public UserAvailableBooksOption getData() {
        return getAvailableListsForUsers();
    }
}
