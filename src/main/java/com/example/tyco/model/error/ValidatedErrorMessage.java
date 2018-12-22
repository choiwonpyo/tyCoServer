package com.example.tyco.model.error;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.example.tyco.model.JsonResultMessage;

import lombok.Getter;

public class ValidatedErrorMessage implements JsonResultMessage{
	@Getter
	private boolean success = false;
	@Getter
	private Map<String, String> resultObject;
	public ValidatedErrorMessage(Errors errors) {
		this.resultObject = new HashMap<>();
		List<FieldError> fieldErrors = errors.getFieldErrors();
		for(Iterator<FieldError> errorIterator = fieldErrors.iterator(); errorIterator.hasNext();) {
			FieldError error = errorIterator.next();
			if(error != null) {
				resultObject.put(error.getField(), error.getDefaultMessage());
			}	
		}
	}
}
