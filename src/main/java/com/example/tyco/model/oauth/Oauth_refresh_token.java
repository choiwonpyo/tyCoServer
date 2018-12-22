package com.example.tyco.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Oauth_refresh_token {
	@Getter
	@Setter
	@Id
	private String token_id;
	@Getter
	@Setter
	@Lob
	private Byte[] token;
	@Getter
	@Setter
	@Lob
	private Byte[] authentication;
}
