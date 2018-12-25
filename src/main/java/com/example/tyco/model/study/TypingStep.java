package com.example.tyco.model.study;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.tyco.model.user.TypingStepUserStudy;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TypingStep {
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TypingStepSubject subject;
	
	@Getter
	@Setter
	private Long step;
	
	@Getter
	@Setter
	private String stepName;
	
	@Getter
	@Setter
	private Long stepScore;
	
	@OneToMany(
	        mappedBy = "typingStep",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@Getter
	@Setter
	@JsonIgnore
	private List<TypingStepUserStudy> typingStepUserStudy = new ArrayList<>();
}
