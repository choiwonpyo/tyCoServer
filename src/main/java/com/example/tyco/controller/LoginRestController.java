package com.example.tyco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tyco.service.user.AuthenticationFacade;
import com.example.tyco.service.user.TyCoUserService;

@RestController
public class LoginRestController {
	@Autowired
	private TyCoUserService tyCoUserService;
	@Autowired
	private AuthenticationFacade auth;
	
	@GetMapping("/resource/isLogined")
	public boolean test() {
		return auth.getAuthentication().isAuthenticated();
	}
}
