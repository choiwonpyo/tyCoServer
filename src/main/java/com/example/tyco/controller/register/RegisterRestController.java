package com.example.tyco.controller.register;

import javax.validation.ConstraintValidator;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tyco.model.JsonResultMessage;
import com.example.tyco.model.JsonSuccessMessage;
import com.example.tyco.model.error.ValidatedErrorMessage;
import com.example.tyco.model.form.TyCoUserForm;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.model.validator.TyCoUserFormValidator;
import com.example.tyco.service.register.RegisterUserService;

@RestController
public class RegisterRestController {

	@Autowired
	private TyCoUserFormValidator tyCoUserFormValidator;
	@Autowired
	private RegisterUserService registerUserService;
	
	@PostMapping("/register")
	public JsonResultMessage register(@Valid @RequestBody TyCoUserForm form, Errors errors) {
		tyCoUserFormValidator.validate(form, errors);
		System.out.println(form.getNickName());
		if(errors.hasErrors()) {
			return new ValidatedErrorMessage(errors);
		}
		TyCoUser makedUser = registerUserService.makeTyCoUser(form);
		TyCoUser registeredUser = registerUserService.register(makedUser);
		return new JsonSuccessMessage(registeredUser);
	}

}
