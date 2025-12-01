package com.example.demo;
//SPRING STARTER AUTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TaskApplication {

	@Autowired
	private GreetingService s;
	@PostConstruct
	public void init()
	{
		System.out.println(s.greet());
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		
	}

}
