package com.example.tyco.controller.register;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tyco.model.JsonFailMessage;
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
		System.out.println(form.getUserName());
		if(registerUserService.findByUserName(form.getUserName())!= null) {
			System.out.println("여기까지는 왔습니다.");
			Map<String, String> resultObject = new HashMap<String, String>();
			resultObject.put("userName", "같은 아이디가 이미 있습니다.");
			return new JsonFailMessage(resultObject);
		}
		System.out.println("여기까지 왔으면 성공 해야죠");
		TyCoUser makedUser = registerUserService.makeTyCoUser(form);
		TyCoUser registeredUser = registerUserService.register(makedUser);
		return new JsonSuccessMessage(registeredUser);
	}

}
