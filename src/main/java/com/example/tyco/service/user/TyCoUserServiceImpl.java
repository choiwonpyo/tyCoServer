package com.example.tyco.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.repository.TyCoUserRepository;

@Service
public class TyCoUserServiceImpl implements TyCoUserService{
	@Autowired
	private TyCoUserRepository tyCoUserRepository;
	
	@Override
	public Optional<TyCoUser> getTyCoUserById(Long id) {
		return tyCoUserRepository.findById(id);
	}
	@Override
	public TyCoUser getTyCoUserByUserName(String userName) {
		return tyCoUserRepository.findByUserUsername(userName);
	}
}
