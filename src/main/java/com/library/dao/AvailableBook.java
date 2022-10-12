package com.library.dao;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Category;

import java.util.List;

interface AvailableBook {

    List<Book> availableBooksByAuthor(Author author);
    List<Book> availableBooksByCategory(Category category);
    List<Book> availableBooks();
}
