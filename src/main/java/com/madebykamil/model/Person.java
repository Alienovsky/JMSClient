package com.madebykamil.model;

import java.io.Serializable;

public class Person implements Serializable{
    private static long serialVersionUID = 1112399434508676095L;
    String name;
    String surname;
    String phone;
    String fax;
    int id;

    public Person(String name, String surname, String phone, String fax, int id) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.fax = fax;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public int getId() {
        return id;
    }
}
