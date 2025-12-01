package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

@Value("${app.message}")
private String msg;

public String greet()
{
	return msg!=null? msg:"Welcome to Spring Boot!";}
}
