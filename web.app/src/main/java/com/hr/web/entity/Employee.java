package com.hr.web.entity;

import jakarta.persistence.*;
import java.util.HashSet;  
import java.util.Set;

//Entity class used to map to the employee table from the database
//@Entity Annotation is used to tell spring boot that this class is an Entity class
//@Table Annotation is used to map the table name to the table with the same name in the database
@Entity
@Table(name = "employee")
public class Employee {

	//@Id Annotation specifies the primary key of this entity
	//@GeneratedValue Annotation automatically generates the primary key value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role",
				joinColumns = @JoinColumn(name = "employee_id"),
				inverseJoinColumns = @JoinColumn(name = "role_name"))
	private Set<Role> role = new HashSet<>();

	//@Column Annotation is used to specify a mapped column for a persistent property or field
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	

	//Setters and getters, used to access the data from the fields or properties
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
		public Employee() {}
		

		//Constructor used to create a new Employee with attributes id, email, firstname, lastname and password
		public Employee(long id, Set role, String email, String password, String firstName, String lastName) {
			this.id = id;
			this.role = role;
			this.email = email;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
	}


}
