package com.ferreirae.code401d4.day12.firstWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// not rest
// Thymeleaf, our view engine will try to handle what we return from these methods
// Thymeleaf expects the string we return to be the name of a template

@Controller
public class NotARestController {

    // visit /notresthello in our browser
    //
    @GetMapping("/notresthello")
    public String getNotRestHello(Model m) {
        // this means that Thymeleaf should render a template named "hello"
        String[] allTheNames = new String[]{"Michelle", "Evan", "Brook", "Reina", "Tisha"};
        m.addAttribute("names", allTheNames);
        return "hello";
    }
}
