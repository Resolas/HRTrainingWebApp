package com.hr.web.entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Employee> employees = new HashSet<>();
	
	//Setters and getters, used to access the data from the fields or properties
	public Long getId() {
		return id;
		}

	public void setId(Long id) {
		this.id = id;
		}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
    public Set<Employee> getUsers() {
        return employees;
    }

    public void setUsers(Set<Employee> users) {
        this.employees = users;
    }

}
