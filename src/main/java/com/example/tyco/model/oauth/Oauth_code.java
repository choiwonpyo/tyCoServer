package com.example.tyco.model.oauth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Oauth_code {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	@Lob
	private Byte[] authentication;
}
