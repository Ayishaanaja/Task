package com.example;

import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    // field injection (will work if you enable annotation processing in beans.xml)
    @Autowired
    private MessageService messageService;

    // no-arg constructor (needed for setter/field injection)
    public UserController() {}

    // constructor injection
    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    // setter injection
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String printMessage() {
        return messageService == null ? "No MessageService injected!" : messageService.getMessage();
    }
}
