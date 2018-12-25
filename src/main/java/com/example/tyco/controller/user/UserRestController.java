package com.example.tyco.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tyco.model.JsonFailMessage;
import com.example.tyco.model.JsonResultMessage;
import com.example.tyco.model.JsonSuccessMessage;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.service.user.AuthenticationFacade;
import com.example.tyco.service.user.TyCoUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserRestController {
	@Autowired
	private TyCoUserService tyCoUserService;
	@Autowired
	private AuthenticationFacade auth;
	@Autowired
	private ObjectMapper customJsonMapper;
	
	@GetMapping("/resource/tyCoUser")
	public JsonResultMessage getTyCoUserInformation() {
		String name = auth.getAuthentication().getName();
		TyCoUser user = tyCoUserService.getTyCoUserByUserName(name);
		
		if(user == null) {
			return new JsonFailMessage(name);
		}
		return new JsonSuccessMessage(user);
	}
}
