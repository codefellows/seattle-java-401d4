package com.ferreirae.code401d4.day12.firstWebApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Mark this class as a controller, so that SpringBoot knows to look at it
@RestController
public class HelloWorldController {

    // specify the route (method and path) for this method
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello, world! It's a beautiful day!";
    }

    @GetMapping("/hello/{name}/{from}")
    public String getHelloToMe(@PathVariable String name, @PathVariable String from) {
        return "Hello, " + name + " from " + from;
    }
}
