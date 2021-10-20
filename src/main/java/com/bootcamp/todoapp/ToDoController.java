package com.bootcamp.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {
    List<String> todoList = new ArrayList<String>();

    public ToDoController() {
        todoList.add("Prvi test");
        todoList.add("Drugi test");
    }


    @GetMapping("/todoapp/save")
    String save(@RequestParam String text) throws IOException {
        System.out.println("New todo received: " + text);
        todoList.add(text);
        return("redirect:/list_all");
    }

    @GetMapping("/todoapp/list_all")
    String listAll(Model model)  {
        System.out.println("Lista all todo.");
        model.addAttribute("todoList", todoList);
        return "/todoapp/list_all";
    }

}
