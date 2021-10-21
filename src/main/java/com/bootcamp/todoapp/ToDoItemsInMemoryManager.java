package com.bootcamp.todoapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoItemsInMemoryManager {

    List<ToDoItem> todoList = new ArrayList<ToDoItem>();

    public List<ToDoItem> getTodoList() {
        return todoList;
    }
}
