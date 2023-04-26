package com.hr.web.services;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.web.entity.Employee;
import com.hr.web.entity.Role;
import com.hr.web.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		
		Employee employee = employeeRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with: " + email));
		
		return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(),
				employee.isEnabled(), true, true, true, getAuthorities(employee.getRole()));
	}
	
	   private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
	                .collect(Collectors.toList());
	    }

}