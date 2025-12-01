package com.example;
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Method to show the message from GreetingService
    public String showMessage() {
        return greetingService.getMessage();
    }
}

