package com.lama.visitormanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VisitorManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorManagementSystemApplication.class, args);
	}

}
