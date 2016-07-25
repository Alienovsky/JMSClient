package com.madebykamil.jms.responses;

import java.io.Serializable;

public class AddBookResponse extends AbstractResponse implements Serializable {
    private static final long serialVersionUID = 555L;
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
