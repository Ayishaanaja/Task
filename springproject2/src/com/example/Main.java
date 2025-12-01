package com.example;
//Console-1
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		GreetingController controller=ctx.getBean(GreetingController.class);
		System.out.println(controller.showMessage());
	}

}
