package com.madebykamil.jms.responses;

import java.io.Serializable;

public class RemoveBookResponse extends  AbstractResponse implements Serializable {
    private static final long serialVersionUID = 888L;

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    private boolean isRemoved;
}
