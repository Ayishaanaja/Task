package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // Map GET requests for the root ("/") path to this method
    @GetMapping("/")
    public String greet() {
        return "Hello!";
    }
}

