package com.hr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.web.entity.Admin;

//UserRepository class used to manage the data access and persistence for user-related operations within
//and application. It is responsible for handling queries and commands related to user accounts, such as creating,updating or deleting users
//@Repository Annotation is used to tell spring boot that this class is a Repository class
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	//Method to find Admin by email address
	 Admin findByEmail(String email);
	 
	 //method to find admin by their name in database
	 Admin findByName(String name);

}
