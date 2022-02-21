package com.cytek.employeemanager.model;

import java.io.Serializable; // Implement serializable from java.io because it helps transform the Java class
							 // into different forms such as JSON

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @author isha_
 * Contains template for how to represent employees in the application
 *
 */

//Make sure that the class is configured to any database configured on the class path
@Entity
public class Employee implements Serializable {

	/** Information that we want each employee object to have */
	/** We want Employee to refer to a table in a database (to make it meaningful). Use the @Id
	 * annotation right before private Long int to indicate that it will be the primary key
	 */
	@Id
	/**
	 * Use @GeneratedValue annotation to tell Java how to generate the primary key value
	 * Can optionally give a strategy type
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Can give even further specifications as to how we want columns to be handled.
	 * Nullable and updatable = false means that once it is set, the id cannot be changed
	 */
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String name;
	private String email;
	private String jobTitle;
	private String phoneNumber;
	private String imageUrl;	// Can be an actual image, but we want to simply point towards the image
	// Cannot change the employee code once it is set
	@Column(nullable = false, updatable = false)
	private String employeeCode;
	
	/**
	 * Constructors
	 */
	public Employee () { }		// Set everything to their defaults
	
	public Employee (String name, String email, String jobTitle, String phoneNumber, String imageUrl, String employeeCode) {
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phoneNumber = phoneNumber;
		this.imageUrl = imageUrl;
		this.employeeCode = employeeCode;
	}
	
	/**
	 * Getters and setters for everything
	 */
	public Long getId () { return this.id; }
	public void setId (Long id) { this.id = id; }
	
	public String getName () { return this.name; }
	public void setname (String name) { this.name = name; }
	
	public String getEmail () { return this.email; }
	public void setEmail (String email) { this.email = email; }
	
	public String getJobTitle () { return this.jobTitle; }
	public void setJobTitle (String jobTitle) { this.jobTitle = jobTitle; }
	
	public String getPhoneNumber () { return this.phoneNumber; }
	public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber; }
	
	public String getImageUrl () { return this.imageUrl; }
	public void setImageUrl (String imageUrl) { this.imageUrl = imageUrl; }
	
	public String getEmployeeCode () { return this.employeeCode; }
	public void setEmployeeCode (String employeeCode) { this.employeeCode = employeeCode; }
	
	/**
	 * To String: In case we want to print out contents of the class
	 */
	@Override
	public String toString () {
		return "------ Employee ------\n" +
				"\t-- id: " + id.toString() + " --\n" +
				"\t-- name: " + name + " --\n" +
				"\t-- email: " + email + " --\n" +
				"\t-- job title: " + jobTitle + " --\n" +
				"\t-- phone number: " + phoneNumber + " --\n" +
				"\t-- image url: " + imageUrl + " --\n" +
				"\t-- employee code: " + employeeCode + " --\n" +
				"---------------------\n";
	}
}
