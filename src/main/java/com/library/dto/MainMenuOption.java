package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.library.dto.UserRole.ADMIN;
import static com.library.dto.UserRole.USER;

@Getter
@AllArgsConstructor
public enum MainMenuOption {
    //    LOG_OUT(USER, ADMIN),
    SHOW_AVAILABLE_BOOKS("Wyświetl dostępne książki", USER),
    ADD_NEW_USER("Dodaj nowego użytkownika", ADMIN),
    ;
//    RENT_BOOK(USER),
//    RETURN_BOOK(USER),
//    SHOW_USER_RENTED_BOOKS(USER)

    private final String describeOption;
    private final UserRole userRole;
}