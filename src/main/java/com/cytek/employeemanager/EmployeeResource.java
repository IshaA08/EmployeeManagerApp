package com.cytek.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cytek.employeemanager.model.Employee;
import com.cytek.employeemanager.service.EmployeeService;

/**
 * @author isha_
 * This is the controller for the application. A controller essentially handles requests coming in and interacting
 * with the data layer (that in turn interacts with the database). Do the API mapping here and essentially mirror
 * whatever is happening in the service
 * 
 * Application flow:
 * HTTP requests ---> Controller ---> Service ---> Database in MySQL
 */


// Specify that this is a REST controller
@RestController
// Make sure that all things accessing the resource have employee in their URL
@RequestMapping("/employee")
public class EmployeeResource {
	
	// Bring in the service layer (because we want to use it in this class)
	private final EmployeeService employeeService;
	
	// Initialize the service in the constructor to make sure that we always actually have a legit reference
	public EmployeeResource (EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 *  Return all employees in the database
	 *  GetMapping: This will be a get request
	 *  @return ResponseEntity Will return an HTTP response, and in the body of the HTTP response is a list of
	 *  					   Employees
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees () {
		
		// Call the service and have it return a list of all employees
		List<Employee> employees = employeeService.findAllEmployees();
		
		// Create an HTTP response with the OK status (and return it too)
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	/**
	 * Create a get method to find a single user. Use the get mapping to further specify the API
	 * and by using a path parameter
	 * @return ResponseEntity<Employee> An HTTP response that contains an Employee
	 * @param @PathVariable("id") Means that we are taking the path variable from the GetMapping annotation,
	 * 							  which is why "id" has to match "id" between both annotations
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
		
		// Call the service and get the employee
		Employee employee = employeeService.findEmployeeById(id);
		
		// Create an HTTP response with the OK status (and return it too)
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	/**
	 * Create a new employee.
	 * PostMapping: Making a post request at the back end
	 * @return ResponseEntity<Employee> An HTTP request that contains the Employee that is added
	 * @param Employee Assume that the HTTP request body has the employee details
	 */
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee givenEmployee) {
		
		// Use the service to create an employee
		Employee employee = employeeService.addEmployee(givenEmployee);
		
		// Return the newly created employee. Use CREATED to indicate that we have created something new on the server
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	/**
	 * Update an existing employee
	 * PutMapping: Updating on back end
	 */
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee givenEmployee) {
		
		// Use the service to update the employee
		Employee employee = employeeService.updateEmployee(givenEmployee);
		
		// Return the updated employee. OK indicates that everything went well at the back end
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	/**
	 * DeleteMapping: Delete an employee
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee (@PathVariable("id") Long id) {
		
		// Use the service to delete the employee
		employeeService.deleteEmployee(id);;
		
		// Simply return OK to show that everything went well to the user
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
