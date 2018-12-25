package com.example.tyco.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ColumnDefault;

import com.example.tyco.model.study.TypingStep;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TypingStepUserStudy {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Getter
	@Setter
	@JsonIgnore
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	@JoinColumn(nullable=true)
	@JsonIgnore
	private TyCoUser tyCoUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private TypingStep typingStep;
	
	@Getter
	@Setter
	@ColumnDefault(value = "false")
	private boolean cleared;
	
	public TypingStepUserStudy (TyCoUser user, TypingStep step, boolean cleared){
		this.tyCoUser = user;
		this.typingStep = step;
		this.cleared = cleared;
	}
	
}
