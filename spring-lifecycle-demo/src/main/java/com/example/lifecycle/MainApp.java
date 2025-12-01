package com.example.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("=== Starting ApplicationContext ===");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== Fetching Bean ===");

        DatabaseConnection db = context.getBean(DatabaseConnection.class);
        db.connect();

        System.out.println("=== Closing Context ===");
        context.close();

        System.out.println("=== End of Application ===");
    }
}
