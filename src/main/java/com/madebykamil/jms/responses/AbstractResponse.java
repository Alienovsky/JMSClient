package com.madebykamil.jms.responses;

import java.io.Serializable;

public class AbstractResponse implements Serializable {
    private static final long serialVersionUID = 151L;
    protected String errors;

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
