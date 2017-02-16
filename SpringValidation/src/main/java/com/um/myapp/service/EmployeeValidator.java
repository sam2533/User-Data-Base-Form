package com.um.myapp.service;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.um.myapp.model.Employee;

public class EmployeeValidator implements org.springframework.validation.Validator {

	public boolean supports(Class<?> paramClass) {	
		return Employee.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "userName", "user.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "password.required");	
	}

}
