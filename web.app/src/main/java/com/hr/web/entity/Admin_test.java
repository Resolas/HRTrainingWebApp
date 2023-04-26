package com.hr.web.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "admin_table")
public class Admin_test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "role",
//				joinColumns = @JoinColumn(name = "admin_id"),
//				inverseJoinColumns = @JoinColumn(name = "role_name"))
//	private Set<Role> role = new HashSet<>();
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
	
	@Column(nullable = false, length = 64)
    private String password;
	
	
	//Setter and Getters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	//Empty Constructor for hibernate
	public Admin_test() {}
	
	//Constructor used to create a new Employee with attributes id, email, firstname, lastname and password
	public Admin_test(long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;

}

}
