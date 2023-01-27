package com.example.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.miniproject.service.StudentService;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}
	
	@Bean
	public StudentService studentService()
	{
		return new StudentService();
	}
	
	/*
	 * @Bean Public StudentRepository studentRepository() { return new
	 * StudentRepository(); }
	 */

}
