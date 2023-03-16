package com.matthewgitata.springdi;

import com.matthewgitata.springdi.controllers.ConstructorInjectedController;
import com.matthewgitata.springdi.controllers.MyController;
import com.matthewgitata.springdi.controllers.PropertyInjectedController;
import com.matthewgitata.springdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);

		System.out.println("--------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.sayGreeting());

		System.out.println("-------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		setterInjectedController.sayGreeting();

		System.out.println("-------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		constructorInjectedController.sayGreeting();
	}

}