package net.javaguides.springboot;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.controller.EmployeeController;

@SpringBootApplication
public class EmployeeManagementWebappApplication {

	public static void main(String[] args) {
				SpringApplication.run(EmployeeManagementWebappApplication.class, args);
	}

}
//Main class or main methods
//@SpringBootApplication marked as a main class and equivalent to @EnableAutoConfiguration + ComponentScan +Configuration 