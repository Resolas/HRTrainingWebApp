package com.hr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

//import com.hr.web.entity.Admin;
import com.hr.web.entity.Admin_test;


//UserRepository class used to manage the data access and persistence for user-related operations within

//and application. It is responsible for handling queries and commands related to user accounts, such as creating,updating or deleting users
//@Repository Annotation is used to tell spring boot that this class is a Repository class
@Repository
public interface AdminRepository extends JpaRepository<Admin_test, Long> {
	
	//Method to find Admin by email address
	 Admin_test findByEmail(String email);
	 
	 //method to find admin by their name in database
	 Admin_test findByName(String password);

}
