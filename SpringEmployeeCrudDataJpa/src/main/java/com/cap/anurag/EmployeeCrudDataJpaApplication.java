package com.cap.anurag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EmployeeCrudDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudDataJpaApplication.class, args);
	}

}
