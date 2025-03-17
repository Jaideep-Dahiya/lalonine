package com.example.demo.demo;

import com.example.demo.demo.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private CommandRegistry commandRegistry;

	@Autowired
	DemoApplication(CommandRegistry commandRegistry){
		this.commandRegistry = commandRegistry;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside Terminal");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println(line);
		commandRegistry.run();
	}
}
