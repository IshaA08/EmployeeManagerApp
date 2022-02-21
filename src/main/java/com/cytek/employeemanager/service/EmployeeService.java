package com.cytek.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytek.employeemanager.exception.UserNotFoundException;
import com.cytek.employeemanager.model.Employee;
import com.cytek.employeemanager.repo.EmployeeRepo;

/**
 * @author isha_
 * Service layer that handles talking with the database itself. Handles data
 */

@Service
@Transactional
public class EmployeeService {
	
	// Bring in the EmployeeRepo (repository) that we just made
	private final EmployeeRepo employeeRepo;
	
	/**
	 *  Use constructor to make sure EmployeeRepo is initialized
	 *  Use @Autowired to bring in the dependency
	 */
	@Autowired
	public EmployeeService (EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	/**
	 * Can do all CRUD operations now. Does all the jdbc operations for us
	 */
	public Employee addEmployee (Employee employee) {
		
		// First, generate new random ID for new employee (should not be asking user to do this)
		employee.setEmployeeCode(UUID.randomUUID().toString());
		
		// Save the employee now
		return employeeRepo.save(employee);
	}
	
	// Return a list of all users in the database
	public List<Employee> findAllEmployees () {
		return employeeRepo.findAll();
	}
	
	// Update employee
	public Employee updateEmployee (Employee employee) {
		return employeeRepo.save(employee);
	}
	
	// Delete employee by giving the employee's id reference (which is the primary key)
	public void deleteEmployee (Long id) {
		
		// Spring will create this query specially for us through naming convention
		employeeRepo.deleteEmployeeById(id);
	}
	
	// Find an employee by ID
	public Employee findEmployeeById (Long id) {
		// Can throw an error in case it does not exist (from optional return)
		return employeeRepo
				.findEmployeeById(id)
				.orElseThrow( 
						() -> new UserNotFoundException ("User by id " + id.toString() + " was not found.") 
						);   
	}
	

}
