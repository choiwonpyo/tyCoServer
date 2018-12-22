package com.example.tyco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tyco.model.oauth.users_authority.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	public Authority findByName(String name);
}
