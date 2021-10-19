package com.bootcamp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {
    List<String> todoList = new ArrayList<String>();

    @GetMapping("/save")
    void save(@RequestParam String text,
              HttpServletResponse response) throws IOException {
        System.out.println("New todo received: " + text);
        todoList.add(text);


        response.getWriter().println("Thank you!\n");

        response.getWriter().println("Todo items:");
        for(String i : todoList)
            response.getWriter().println(i);

    }

    @GetMapping("/list_all")
    void listAll(HttpServletResponse response) throws IOException {
        for(String i : todoList)
            response.getWriter().println(i);


    }

}
