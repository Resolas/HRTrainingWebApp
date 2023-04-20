package com.hr.web.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;
import java.util.List;

import com.hr.web.entity.Employee;
import com.hr.web.entity.Role;
import java.util.ArrayList;

public class CustomEmployeeDetails implements UserDetails {
	
	private Employee employee;
	
	public CustomEmployeeDetails(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return getAuthorities();
	}
	
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities(){
//	    Set<Role> roles = employee.getRole();
//	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//	    for (Role role : roles) {
//	        authorities.add(new SimpleGrantedAuthority(role.getRole()));
//	    }
//	    return authorities;
//		
//		
//		//return employee.getRoles();
//		
//	}//end Collection method
	
	@Override
	public String getPassword() {
		return employee.getPassword();
	}//end getPassword method
	
	@Override
	public String getUsername() {
		return employee.getEmail();	
	}//end getUsername method
	
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
	
	
	
	

}
