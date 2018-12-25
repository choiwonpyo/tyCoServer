package com.example.tyco.service.study;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.user.TyCoUser;

public interface TypingStepClearService {

	void clearThisStep(TyCoUser user, TypingStep step);

	boolean isCleared(TyCoUser user, TypingStep step);

}
