package com.example.tyco.service.study;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.model.user.TypingStepUserStudy;
import com.example.tyco.repository.TypingStepUserStudyRepository;

@Service
public class TypingStepClearServiceImpl implements TypingStepClearService{

	@Autowired
	private TypingStepUserStudyRepository typingStepUserStudyRepository;
	
	@Override
	public void clearThisStep(TyCoUser user, TypingStep step) {
		if(!isCleared(user, step)) {
			TypingStepUserStudy study = new TypingStepUserStudy(user, step, true);
			typingStepUserStudyRepository.save(study);
		}
	}
	
	@Override
	public boolean isCleared(TyCoUser user, TypingStep step) {
		Optional<TypingStepUserStudy> oStudy = typingStepUserStudyRepository.findByTyCoUserAndTypingStep(user, step);
		if(!oStudy.isPresent()) {
			return false;
		}
		return true;
	}
}
