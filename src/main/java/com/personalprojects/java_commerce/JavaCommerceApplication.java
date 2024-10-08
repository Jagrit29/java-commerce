package com.personalprojects.java_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCommerceApplication implements CommandLineRunner {

	// now to tell bean, here we need to use autowired
	@Autowired
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(JavaCommerceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// Now this db will be automatically given an object by Bean;
		System.out.println(db.getData());
	}
}
