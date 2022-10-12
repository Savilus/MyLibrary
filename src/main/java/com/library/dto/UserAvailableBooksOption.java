package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserAvailableBooksOption {

    ALL_AVAILABLE_BOOK("Wszystkie dostępne książki", 1),
    AVAILABLE_BOOK_BY_CATEGORY("Dostępne książki po kategorii", 2),
    AVAILABLE_BOOK_BY_AUTHOR("Dostępbe książki po autorze", 3);


    private final String describeOption;
    private final int userChoice;
}
