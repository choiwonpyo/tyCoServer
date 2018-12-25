package com.example.tyco.controller.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tyco.model.JsonFailMessage;
import com.example.tyco.model.JsonResultMessage;
import com.example.tyco.model.JsonSuccessMessage;
import com.example.tyco.model.form.TypingStepClearForm;
import com.example.tyco.model.study.TypingStep;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.service.study.TypingStepClearService;
import com.example.tyco.service.study.TypingStepService;
import com.example.tyco.service.user.AuthenticationFacade;
import com.example.tyco.service.user.TyCoUserService;

@RestController
public class TypingStepRestController {
	
	@Autowired
	private AuthenticationFacade auth;
	
	@Autowired
	private TyCoUserService tyCoUserService;
	
	@Autowired
	private TypingStepClearService typingStepClearService;
	
	@Autowired
	private TypingStepService typingStepService;
	
	@PostMapping("/resource/typingStep/clear")
	private JsonResultMessage clear(@RequestBody TypingStepClearForm form) {
		System.out.println("here");
		String name = auth.getAuthentication().getName();
		System.out.println(name);
		TyCoUser user = tyCoUserService.getTyCoUserByUserName(name);
		if(user == null) {
			return new JsonFailMessage("there is no user");
		}
		TypingStep step = null;
		try {
			step = this.typingStepService.getTypingStepBySubjectAndStep(form.getSubject(), form.getStep());
		}catch(NullPointerException exeption) {
			System.out.println("step is null");
		}
		this.typingStepClearService.clearThisStep(user, step);
		
		return new JsonSuccessMessage("clear");
	}
}
