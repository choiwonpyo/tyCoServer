package com.example.tyco.model;

import lombok.Getter;

public class JsonFailMessage implements JsonResultMessage{
	@Getter
	private boolean success = false;
	@Getter
	private Object resultObject;
	
	public JsonFailMessage(Object resultObject) {
		this.resultObject = resultObject;
	}
}
