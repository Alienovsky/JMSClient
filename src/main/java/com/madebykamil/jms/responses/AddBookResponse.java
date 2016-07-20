package com.madebykamil.jms.responses;

import java.io.Serializable;

public class AddBookResponse implements Serializable {
    private static final long serialVersionUID = 555L;
    private String errors = "";
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
