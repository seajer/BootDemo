package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.JpaConfig;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {App.class, JpaConfig.class}, args);
	}
}
