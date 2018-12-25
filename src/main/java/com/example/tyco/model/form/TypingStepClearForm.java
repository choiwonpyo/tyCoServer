package com.example.tyco.model.form;

import com.example.tyco.model.study.TypingStepSubject;

import lombok.Getter;
import lombok.Setter;

public class TypingStepClearForm {
	@Getter
	@Setter
	private TypingStepSubject subject;
	
	@Getter
	@Setter
	private Long step;
}
