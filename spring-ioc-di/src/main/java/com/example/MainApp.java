package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        UserController user = context.getBean(UserController.class);
        System.out.println(user.printMessage());
        ((ClassPathXmlApplicationContext) context).close();
    }
}
