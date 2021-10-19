package com.bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {

    @GetMapping("/sum")
    public void sumTwoNumber(@RequestParam int a,
                             @RequestParam int b,
                             HttpServletResponse response) throws IOException {
        int sum = a + b;
        response.getWriter().println("Sum: " + sum);
    }
}
