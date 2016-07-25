package com.madebykamil.jms.responses;

import com.madebykamil.model.Book;

import java.io.Serializable;

public class GetBookByIdResponse extends AbstractResponse implements Serializable {
    private static final long serialVersionUID = 777L;
    private Book book;

    public GetBookByIdResponse(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
