package com.instanthire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class InstantHireApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstantHireApplication.class, args);
	}
}
