package com.um.myapp.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.um.myapp.model.User;

public class UserFormValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object obj, Errors error) {
		User user = (User) obj;
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			error.rejectValue("confirmPassword"	, "Diff.username.confirmPassword");
		}	
	}
}
