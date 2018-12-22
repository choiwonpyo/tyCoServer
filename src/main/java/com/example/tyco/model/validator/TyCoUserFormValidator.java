package com.example.tyco.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.tyco.model.form.TyCoUserForm;

@Component
public class TyCoUserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return TyCoUserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TyCoUserForm userForm = (TyCoUserForm)target;
		if(userForm.getNickName().length() < 2) {
			errors.rejectValue("nickName", "nickName.short", "닉네임이 너무 짧다 임마.");
		}
		if(userForm.getPassword().length() < 5) {
			errors.rejectValue("password", "password.short", "비밀번호가 너무 짧다.");
		}
		if(!userForm.getPassword().equals(userForm.getPasswordCheck())) {
			errors.rejectValue("passwordCheck", "passwordCheck.different", "비밀번호 확인과 비밀번호가 다르다.");
		}
		if(userForm.getUserName() == null || userForm.getUserName().length() < 5) {
			errors.rejectValue("userName", "userName.short", "아이디가 너무 짧다.");
		}
	}

}
