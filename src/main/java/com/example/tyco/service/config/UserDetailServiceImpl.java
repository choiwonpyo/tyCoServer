package com.example.tyco.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tyco.model.oauth.users_authority.User;
import com.example.tyco.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     User user = userRepository.findByUsername(username);
	        if (user != null) {
	            return user;
	        }
	    throw new UsernameNotFoundException(username);
	}
}
