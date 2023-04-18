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
	
	/* Code Templates USE THEM!!!
	
	Add this to the registry
	
	registry.addViewController("/mypage").setViewName("mypage");
	
	
	HTML Button template Note: do not add .html to the href link
	
	<a class="button" href="mypage">mypage</a>
	
	*/
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/user").setViewName("user");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/label").setViewName("employee");
		
		// User pages
		registry.addViewController("/application").setViewName("application");
		registry.addViewController("/evaluationpart1").setViewName("evaluationpart1");
		registry.addViewController("/evaluationpart2").setViewName("evaluationpart2");
		registry.addViewController("/pendingapplication").setViewName("pendingapplication");
		

		// Admin pages
		registry.addViewController("/employeepersonaldetailspart1").setViewName("employeepersonaldetailspart1");
		registry.addViewController("/employeepersonaldetailspart2").setViewName("employeepersonaldetailspart2");
		registry.addViewController("/evaluationpart1").setViewName("/evaluationpart1");
		registry.addViewController("/evaluationpart2").setViewName("/evaluationpart2");
		registry.addViewController("/admin registration").setViewName("admin registration");
		registry.addViewController("/employeeregistration").setViewName("employeeregistration");
	}//end addViewControllers Method

}
