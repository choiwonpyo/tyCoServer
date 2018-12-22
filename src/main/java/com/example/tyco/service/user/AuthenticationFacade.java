package com.example.tyco.service.user;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
	 Authentication getAuthentication();
}
