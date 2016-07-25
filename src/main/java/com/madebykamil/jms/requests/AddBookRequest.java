package com.madebykamil.jms.requests;

import java.io.Serializable;

public class AddBookRequest implements Serializable {
    private static final long serialVersionUID = 111L;
    private String authorName;
    private String authorSurname;
    private String title;
    private String genre;
    private Float price;
    private String description;

    /*public AddBookRequest(String authorName, String authorSurname, String title, String genre, Float price, String description) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.description = description;
    }*/

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
