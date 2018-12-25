package com.example.tyco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.study.TypingStepSubject;

public interface TypingStepRepository extends JpaRepository<TypingStep, Long> {
	Optional<TypingStep> findBySubjectAndStep(TypingStepSubject subject, Long step);
} 
