package com.bootcamp.todoapp;

import java.util.Date;

public class ToDoItem {
    private Date timestamp;
    private String text;

    public ToDoItem(Date timestamp, String text) {
        this.timestamp = timestamp;
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
