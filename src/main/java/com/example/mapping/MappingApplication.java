package com.example.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

}
