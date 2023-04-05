package com.hr.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	//Method for mapping a URL with a view.
	//Adds 5 views, 2 of which reference the homepage("/" and "/home")
	//Also adds view which is reference for user page("/user")
	//Another view which is refernce for admin page("/admin")
	//And a view which is a reference for the login page("/login")
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/user").setViewName("user");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/label").setViewName("employee");
		registry.addViewController("/evaluationpart1").setViewName("evaluationpart1");
		
		
	}//end addViewControllers Method

}
