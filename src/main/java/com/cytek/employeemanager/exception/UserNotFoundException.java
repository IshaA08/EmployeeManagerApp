package com.cytek.employeemanager.exception;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {
	
	// Simply call the super class and pass along the given message
	public UserNotFoundException (String message) {
		super(message);
	}

}
