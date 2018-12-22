package com.example.tyco.model;

import lombok.Getter;

public class JsonSuccessMessage implements JsonResultMessage{
	@Getter
	private boolean success = true;
	@Getter
	private Object resultObject;
	
	public JsonSuccessMessage(Object resultObject) {
		this.resultObject = resultObject;
	}
}
