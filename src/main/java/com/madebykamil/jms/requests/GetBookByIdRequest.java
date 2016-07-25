package com.madebykamil.jms.requests;

import java.io.Serializable;

public class GetBookByIdRequest implements Serializable {
    private static final long serialVersionUID = 333L;
    private String bookId;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
