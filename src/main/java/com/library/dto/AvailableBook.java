package com.library.dto;

import com.library.model.Author;
import com.library.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AvailableBook {


    private String title;
    private String isbn;
    private Author author;
    private Category category;
    private int availableAmount;
}
