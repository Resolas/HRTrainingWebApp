package com.hr.web.app;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Main class with main Method used for running application
//@EnableJpaRepositories(basePackages = "com.hr.web.repository")
@ComponentScan(basePackages = "com.hr.web")
@Import(SecurityConfig.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
