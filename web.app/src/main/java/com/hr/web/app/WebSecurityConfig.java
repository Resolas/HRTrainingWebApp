package com.hr.web.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;   
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User; 
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

//Class to configure Security for login
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
	
	@Autowired
	private UserDetailsService adminDetailsService;
	
	@Autowired
	private UserDetailsService employeeDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	   @Autowired
	    public WebSecurityConfig(UserDetailsService adminDetailsService,
	                             UserDetailsService employeeDetailsService,
	                             PasswordEncoder passwordEncoder) {
	        this.adminDetailsService = adminDetailsService;
	        this.employeeDetailsService = employeeDetailsService;
	        this.passwordEncoder = passwordEncoder;
	    }
	
	//Bean class to authorize HTTP requests and set roles of users
	//Class also authenticates users and shows login and logout form
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/user").hasRole("USER")
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/label").hasRole("USER")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/login")
					.permitAll()
					//.successForwardUrl("/user")
					// The success handler is what directs the user to their respective pages
					.successHandler((request, response, authentication) -> {
				        if (authentication.getAuthorities().stream()
				                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				            response.sendRedirect("/admin");
				        } else if (authentication.getAuthorities().stream()
				                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
				            response.sendRedirect("/user");
				        } else {
				            throw new IllegalStateException();
				        }
				    })
					.and()
			)
			.logout((logout) -> logout.permitAll())
			.userDetailsService(adminDetailsService)
			.userDetailsService(employeeDetailsService);
		return http.build();
	}//End SecurityFilterChain Method
	
	  @Bean
	    public AuthenticationManager authenticationManager() {
	        // Create and configure the authentication providers for your project
	        AuthenticationProvider adminAuthenticationProvider = adminAuthenticationProvider();
	        AuthenticationProvider employeeAuthenticationProvider = employeeAuthenticationProvider();

	        // Use ProviderManager as the implementation of AuthenticationManager
	        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(
	                adminAuthenticationProvider,
	                employeeAuthenticationProvider
	        ));

	        return authenticationManager;
	    }//end AuthenticationManager
	  
	    @Bean
	    public AuthenticationProvider adminAuthenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(adminDetailsService);
	        authenticationProvider.setPasswordEncoder(passwordEncoder);

	        // Additional configuration for admin authentication provider, if needed

	        return authenticationProvider;
	    }//end adminAuthenticationProvider
	    
	    @Bean
	    public AuthenticationProvider employeeAuthenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(employeeDetailsService);
	        authenticationProvider.setPasswordEncoder(passwordEncoder);

	        // Additional configuration for employee authentication provider, if needed

	        return authenticationProvider;
	    }
	
	
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }//end PasswordEncoder Method

}
