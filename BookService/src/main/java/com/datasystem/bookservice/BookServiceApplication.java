package com.datasystem.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.cloudyrock.spring.v5.EnableMongock;

@EnableMongock
@EnableMongoRepositories(basePackages = "com.datasystem.bookservice.repository")
@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}
