package com.example.tyco.service.register;

import com.example.tyco.model.oauth.users_authority.Authority;

public interface AuthorityService {
	Authority findByName(String name);
	Authority findById(Long id);
}
