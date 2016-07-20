package com.madebykamil.jms.responses;

import com.madebykamil.model.Book;

import java.io.Serializable;
import java.util.List;

public class GetAllBooksResponse implements Serializable {
    private static final long serialVersionUID = 666L;
    private List<Book> allBooks;

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }
}
