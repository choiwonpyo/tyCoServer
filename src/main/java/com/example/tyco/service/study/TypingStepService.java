package com.example.tyco.service.study;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.study.TypingStepSubject;

public interface TypingStepService {

	TypingStep getTypingStepBySubjectAndStep(TypingStepSubject subject, Long step);

}
