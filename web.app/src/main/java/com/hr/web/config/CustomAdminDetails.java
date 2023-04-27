package com.hr.web.config;

import java.util.ArrayList;  
import java.util.Collection;
//import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hr.web.entity.Admin;
import com.hr.web.entity.Role;

public class CustomAdminDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Admin admin;
	
	public CustomAdminDetails(Admin admin) {
		this.admin = admin;	
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
	    Set<Role> roles = admin.getRole();
	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    for (Role role : roles) {
	        authorities.add(new SimpleGrantedAuthority(role.getRole()));
	    }
	    return authorities;		
	}//end Collection method
	
    @Override
    public String getPassword() {
        return admin.getPassword();
    }
    
    @Override
    public String getUsername() {
        return admin.getEmail();
    }
    
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
    
    public Admin getAdmin() {
    	return admin;
    }
	
	

}
