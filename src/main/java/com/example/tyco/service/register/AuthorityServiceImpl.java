package com.example.tyco.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tyco.model.oauth.users_authority.Authority;
import com.example.tyco.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority findByName(String name) {
		if(this.authorityRepository.findByName(name) == null) {
			throw new NullPointerException();
		}
		return this.authorityRepository.findByName(name);
	}
	
	@Override
	public Authority findById(Long id) {
		if(!this.authorityRepository.findById(id).isPresent()) {
			throw new NullPointerException();
		}
		return this.authorityRepository.findById(id).get();
	}
	
}
