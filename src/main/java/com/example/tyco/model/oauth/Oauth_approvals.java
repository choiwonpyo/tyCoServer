package com.example.tyco.model.oauth;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Oauth_approvals {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Setter
    private String userId;
	@Getter
	@Setter
	private String clientId;
	@Getter
	@Setter
	private String scope;
	@Getter
	@Setter
	private String status;
	@Getter
	@Setter
	private LocalDateTime expiresAt;
	@Getter
	@Setter
	private LocalDateTime lastModifiedAt;
}
