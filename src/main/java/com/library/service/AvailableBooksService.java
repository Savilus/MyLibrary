package com.library.service;

import com.library.dao.AvailableBookDao;
import com.library.dto.AvailableBook;
import com.library.dto.UserAvailableBooksOption;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AvailableBooksService {

    private final AvailableBookDao availableBookDao;

    public AvailableBooksService(AvailableBookDao availableBookDao) {
        this.availableBookDao = availableBookDao;
    }

    public AvailableBooksService() {
        this.availableBookDao = new AvailableBookDao();
    }

    public List<AvailableBook> getAvailableBooks() {
        List<Book> books = availableBookDao.availableBooks();
        List<AvailableBook> availableBooks = new ArrayList<>();

        for (Book book : books) {
            String title = book.getTitle();
            String isbn = book.getIsbn();
            Author author = book.getAuthor();
            Category category = book.getCategory();
            int availableAmount = book.getAvailableAmount();

            AvailableBook availableBook = new AvailableBook(title, isbn, author, category, availableAmount);
            availableBooks.add(availableBook);
        }
        return availableBooks;
    }

    public List<AvailableBook> getAvailableBooksByAuthor(Author authorFromUser) {
        List<Book> books = availableBookDao.availableBooksByAuthor(authorFromUser);
        List<AvailableBook> availableBooks = new ArrayList<>();

        for (Book book : books) {
            String title = book.getTitle();
            String isbn = book.getIsbn();
            Author author = book.getAuthor();
            Category category = book.getCategory();
            int availableAmount = book.getAvailableAmount();

            AvailableBook availableBook = new AvailableBook(title, isbn, author, category, availableAmount);
            availableBooks.add(availableBook);
        }
        return availableBooks;
    }

    public List<AvailableBook> getAvailableBooksByCategory(String categoryFromUser) {
        List<Book> books = availableBookDao.availableBooks();
        List<AvailableBook> availableBooks = new ArrayList<>();

        for (Book book : books) {
            String title = book.getTitle();
            String isbn = book.getIsbn();
            Author author = book.getAuthor();
            Category category = book.getCategory();
            int availableAmount = book.getAvailableAmount();

            if (category.getCategory().equals(categoryFromUser)) {
                AvailableBook availableBook = new AvailableBook(title, isbn, author, category, availableAmount);
                availableBooks.add(availableBook);
            }
        }
        return availableBooks;
    }

    public List<UserAvailableBooksOption> getUserAvailableBooksOptions() {
        return Arrays.stream(UserAvailableBooksOption.values()).collect(toList());
    }
}
