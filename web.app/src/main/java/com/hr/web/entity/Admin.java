package com.hr.web.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
	
	@Column(nullable = false, length = 64)
    private String password;
	
	@Column(name = "first name", nullable = false, length = 20)
    private String firstName;
	
	@Column(name = "last name", nullable = false, length = 20)
	private String lastName;
	
	
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
	
	//Empty Constructor for hibernate
	public Admin() {}
	
	//Constructor used to create a new Employee with attributes id, email, firstname, lastname and password
	public Admin(long id, String email, String password, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
}

}
