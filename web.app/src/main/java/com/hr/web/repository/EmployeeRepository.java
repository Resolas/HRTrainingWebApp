package com.hr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

import com.hr.web.entity.Employee;
//UserRepository class used to manage the data access and persistence for user-related operations within
//and application. It is responsible for handling queries and commands related to user accounts, such as creating,updating or deleting users

//@Repository Annotation is used to tell spring boot that this class is a Repository class
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	//Method to find user in database by their email address
	 Employee findByEmail(String email);
	 
	 //Method to find user in database by their name
	 Employee findByName(String name);

}
