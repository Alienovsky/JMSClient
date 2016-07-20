package com.madebykamil.jms.requests;

import java.io.Serializable;

public class RemoveBookRequest implements Serializable {
    private static final long serialVersionUID = 444L;
    private String bookId;

    public RemoveBookRequest(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
