package com.um.myapp.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.um.myapp.model.FileBucket;


public class FileValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return FileBucket.class.isAssignableFrom(arg0);
	}

	public void validate(Object obj, Errors error) {
		FileBucket file = (FileBucket) obj;
		
		if(file.getFile() != null){
			if(file.getFile().getSize() == 0){
				error.rejectValue("file", "missing.file");
			}
		}
}
}
