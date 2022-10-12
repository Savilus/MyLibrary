package com.library.dao;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Category;
import com.library.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class AvailableBookDao implements AvailableBook {

    @Override
    public List<Book> availableBooksByAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> availableBooksByAuthor = session.createQuery("SELECT b FROM Book AS b"
                        + "JOIN Author AS A ON A.Author_ID = b.Author_ID  "
                        + "WHERE b.available_amount > 0"
                        + "AND Author.last_name = :authorName"
                        + "AND Author.last_name = :authorLastName", Book.class)
                .setParameter("authorName", author.getName())
                .setParameter("authorLastName", author.getLastName())
                .stream().collect(Collectors.toList());
        session.close();
        return availableBooksByAuthor;
    }

    @Override
    public List<Book> availableBooksByCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> availableBooksByCategory = session.createQuery("SELECT b FROM Book AS b"
                        + "JOIN Category AS cat b.category_id = cat.category_id"
                        + "WHERE cat.category = :category", Book.class)
                .setParameter("category", category.getCategory())
                .stream().collect(Collectors.toList());
        session.close();
        return availableBooksByCategory;
    }

    public List<Book> availableBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> availableBooks = session.createQuery("SELECT b FROM Book AS b"
                        + "WHERE b.available_amount > 0", Book.class)
                .stream()
                .collect(Collectors.toList());
        session.close();
        return availableBooks;
    }
}
