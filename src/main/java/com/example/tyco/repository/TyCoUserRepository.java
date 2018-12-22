package com.example.tyco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tyco.model.user.TyCoUser;

public interface TyCoUserRepository extends JpaRepository<TyCoUser, Long> {
	TyCoUser findByUserUsername(String userName);
}
