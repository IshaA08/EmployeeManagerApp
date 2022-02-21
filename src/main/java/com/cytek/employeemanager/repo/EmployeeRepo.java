package com.cytek.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytek.employeemanager.model.Employee;

/**
 * 
 * @author isha_
 * Can use this to save employees in the code
 * Need to tell JpaRepository what class we are making it for, which is the employee, alongside the type of the
 * primary key (which is long)
 */
public interface EmployeeRepo extends JpaRepository <Employee, Long> {

	// Query methods by convention. Spring will create a query from this
	void deleteEmployeeById (Long id);
	
	// Use optional in case the employee requested does not exist
	Optional<Employee> findEmployeeById(Long id);

}
