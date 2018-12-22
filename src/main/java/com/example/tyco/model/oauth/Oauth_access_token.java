package com.example.tyco.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Oauth_access_token {
	@Getter
	@Setter
	private String token_id;
	@Getter
	@Setter
	@Lob
	private Byte[] token;
	@Getter
	@Setter
	@Id
	private String authentication_id;
	@Getter
	@Setter
	private String user_name;
	@Getter
	@Setter
	private String client_id;
	@Getter
	@Setter
	@Lob
	private Byte[] authentication;
	@Getter
	@Setter
	private String refresh_token;
}
