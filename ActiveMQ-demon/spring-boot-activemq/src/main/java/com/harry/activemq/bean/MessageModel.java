package com.harry.activemq.bean;


import java.io.Serializable;

public class MessageModel  implements Serializable {
    private String titile;
    private String message;

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
