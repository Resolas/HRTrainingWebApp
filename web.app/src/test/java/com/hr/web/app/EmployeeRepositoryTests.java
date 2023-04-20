package com.hr.web.app;

import static org.assertj.core.api.Assertions.assertThat; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;

import com.hr.web.entity.Employee;
import com.hr.web.repository.EmployeeRepository;


//Test class used to persist a user to the database to see if it is working okay.
//@DataJpaTes Annotation is used to disable full auto-configuration and instead apply
//only configuration relevant to JPA tests
//@AutoConfigureTestDatabase(replace = Replace.NONE) Annotation is used to specify that the default test database configuration provided by spring boot should not be replaced
//@Rollback(false) is used to disable transaction rollback after each test
//@EnableJpaRepositories("com.hr.web.repository") is used to show the main method of the application to look in the
//repositories package for repositories


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@EnableJpaRepositories("com.hr.web.repository")
public class EmployeeRepositoryTests {


	//@Autowired Annotation is used to inject dependencies automatically into a spring managed bean
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository userRepository;

	//Method to add user to database for testing connection and persistence
	@Test
	public void testCreateUser() {

		Employee employee = new Employee();
		employee.setEmail("Lisa@gmail.com");
		employee.setFirstName("Lisa");
		employee.setLastName("O Sullivan");
		employee.setPassword("admin");

		//save user to repository
		Employee savedUser = userRepository.save(employee);
		//find existing user by id
		Employee existUser = entityManager.find(Employee.class, savedUser.getId());

		//run check to see if user email is equal to existing user in the entityManager
		assertThat(employee.getEmail()).isEqualTo(existUser.getEmail());

	}//end testCreateUser method

}
