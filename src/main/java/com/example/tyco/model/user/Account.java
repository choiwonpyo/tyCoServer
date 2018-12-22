package com.example.tyco.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Account {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String accountName;
	
	@Getter
	@Setter
	private String password;
	

	
	@Getter
	@Setter
	@ColumnDefault(value = "true")
	private boolean enabled;
	
}
