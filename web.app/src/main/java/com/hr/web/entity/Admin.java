package com.hr.web.entity;

import java.util.HashSet;   
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role",
				joinColumns = @JoinColumn(name = "admin_id"),
				inverseJoinColumns = @JoinColumn(name = "role_name"))
	private Set<Role> role = new HashSet<>();
	
	@Column(nullable = false, unique = true, length = 64)
    private String email;
	
	@Column(name = "first name", nullable = false, length = 64)
    private String firstName;
	
	@Column(name = "last name", nullable = false, length = 64)
	private String lastName;
	
	@Column(nullable = false, length = 64)
    private String password;
	
	
	//Setter and Getters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Role> getRole() {
		return role;
		}

	public void setRole(Set<Role> role) {
		this.role = role;
		}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Empty Constructor for hibernate
	public Admin() {}
	
	//Constructor used to create a new Employee with attributes id, email, firstname, lastname and password
	public Admin(long id, Set<Role> role, String email, String password, String firstName, String lastName) {
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
}//end constructor

}
