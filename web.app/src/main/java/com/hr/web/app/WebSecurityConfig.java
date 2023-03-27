package com.hr.web.app;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Class to configure Security for login
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//Bean class to authorize HTTP requests and set roles of users
	//Class also authenticates users and shows login and logout form  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/user").hasRole("USER")
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/login")
					.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		return http.build();		
					
	}//End SecurityFilterChain Method
	
	
	//Bean class for storing user details
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("user")
            .password(encoder.encode("user"))
            .roles("USER")
            .build();
        UserDetails admin = User.withUsername("admin")
        	.password(encoder.encode("admin"))
        	.roles("ADMIN")
        	.build();
        return new InMemoryUserDetailsManager(user, admin);
    }
	
	

}
