package com.example.tyco.model.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TyCoUserForm {
	@Getter
	@Setter
	@NotNull
	private String userName;
	@Getter
	@Setter
	@NotNull
	private String password;

	@Getter
	@Setter
	@NotNull
	private String passwordCheck;
	
	@Getter
	@Setter
	@NotNull
	private String nickName;
}
