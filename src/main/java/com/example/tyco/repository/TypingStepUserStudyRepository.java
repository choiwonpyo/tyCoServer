package com.example.tyco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.model.user.TypingStepUserStudy;

public interface TypingStepUserStudyRepository extends JpaRepository<TypingStepUserStudy, Long> {
	Optional<TypingStepUserStudy> findByTyCoUserAndTypingStep(TyCoUser tyCoUser, TypingStep typingStep);
}
