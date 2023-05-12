package com.hr.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
//import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.hr.web.entity.Admin;
import com.hr.web.entity.Role;
import com.hr.web.repository.AdminRepository;

@Service
@Primary
public class AdminDetailsServiceImpl implements UserDetailsService{

	
	//@Autowired
	private AdminRepository adminRepository;
	
	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
	
	@Override
	//@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Admin admin = adminRepository.findByEmail(email);
		if(admin == null) {
			throw new UsernameNotFoundException("Admin not found with email: " + email);
//			return new org.springframework.security.core.userdetails.User(
//					admin.getEmail(),
//					admin.getPassword(),
//					admin.getRole().stream().map(role -> new SimpleGrantedAuthority("Role_" + role.getRole())).collect(Collectors.toList())
//					);
		}//end if
				//.orElseThrow(() -> new EmailNotFoundException("Admin not found with Email: " + email));
		
		return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(),
				true, true, true, true, getAuthorities(admin.getRole()));
	}//end loadUserByUsername method
	


}
