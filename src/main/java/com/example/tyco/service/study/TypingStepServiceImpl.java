package com.example.tyco.service.study;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.study.TypingStepSubject;
import com.example.tyco.repository.TypingStepRepository;

@Service
public class TypingStepServiceImpl implements TypingStepService {
	@Autowired
	private TypingStepRepository typingStepRepository;
	
	@Override
	public TypingStep getTypingStepBySubjectAndStep(TypingStepSubject subject, Long step) {
		Optional<TypingStep> oStep = typingStepRepository.findBySubjectAndStep(subject, step);
		if(!oStep.isPresent()) {
			throw new NullPointerException();
		}
		return oStep.get();
	}
}
