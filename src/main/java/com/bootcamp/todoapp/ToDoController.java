package com.bootcamp.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

@Controller
public class ToDoController {

    @Autowired
    ToDoItemsInMemoryManager toDoItemsManager;

    @PostConstruct // after construction of class by Spring is done
    public void init() {
        toDoItemsManager.getTodoList().add(new ToDoItem(new Date(), "Prvi test"));
        toDoItemsManager.getTodoList().add(new ToDoItem(new Date(), "Drugi test"));
    }

    @GetMapping("/todoapp/")
    String root() {
        return "redirect:/todoapp/enter_todo.html";
    }

    @GetMapping("/todoapp/save")
    String save(@RequestParam String text) throws IOException {
        System.out.println("New todo: " + text);

        ToDoItem item = new ToDoItem(new Date(), text);

        toDoItemsManager.getTodoList().add(item);
        return "redirect:/todoapp/list_all";
    }

    @GetMapping("/todoapp/list_all")
    String listAll(Model model)  {
        System.out.println("List all todo.");

        model.addAttribute("todoList", toDoItemsManager.getTodoList());
        return "/todoapp/list_all";
    }

}
