package com.example.tyco.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Oauth_client_details {
	@Getter
	@Setter
	@Id
	private String client_id;
	@Getter
	@Setter
	private String resource_ids;
	@Getter
	@Setter
	private String client_secret;
	@Getter
	@Setter
	private String scope;
	@Getter
	@Setter
	private String authorized_grant_types;
	@Getter
	@Setter
	private String web_server_redirect_uri;
	@Getter
	@Setter
	private String authorities;
	@Getter
	@Setter
	private int access_token_validity;
	@Getter
	@Setter
	private int refresh_token_validity;
	@Getter
	@Setter
	private String additional_information;
	@Getter
	@Setter
	private String autoapprove;
}
