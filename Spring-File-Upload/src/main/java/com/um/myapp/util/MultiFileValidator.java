package com.um.myapp.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.um.myapp.model.FileBucket;
import com.um.myapp.model.MultiFileBucket;


public class MultiFileValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return MultiFileBucket.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj, Errors errors) {
		MultiFileBucket multiFile = (MultiFileBucket) obj;
		
		int index = 0;
		
		for(FileBucket file : multiFile.getFiles()){
			if(file.getFile() != null){
				if(file.getFile().getSize() == 0){
					errors.rejectValue("files["+index+"].file", "missing.file");
				}
			}
			index++;
		}
		
	}

}
