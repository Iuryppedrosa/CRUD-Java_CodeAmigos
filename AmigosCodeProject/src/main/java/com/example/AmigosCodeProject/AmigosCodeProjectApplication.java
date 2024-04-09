package com.example.AmigosCodeProject;

import com.example.AmigosCodeProject.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AmigosCodeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigosCodeProjectApplication.class, args);
	}
}
