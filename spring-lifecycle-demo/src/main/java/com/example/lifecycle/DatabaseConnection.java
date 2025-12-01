package com.example.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class DatabaseConnection implements InitializingBean, DisposableBean {

    public DatabaseConnection() {
        System.out.println("[Constructor] DatabaseConnection created");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[@PostConstruct] Bean is initialized");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean] afterPropertiesSet called");
    }

    public void connect() {
        System.out.println("[connect] Using database connection...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("[@PreDestroy] Bean is about to be destroyed");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[DisposableBean] destroy called");
    }
}
