package com.example.tyco.service.register;

import com.example.tyco.model.form.TyCoUserForm;
import com.example.tyco.model.user.TyCoUser;

public interface RegisterUserService {
	public TyCoUser register(TyCoUser user);
	public TyCoUser update(TyCoUser user);
	public TyCoUser makeTyCoUser(TyCoUserForm tyCoUser);
	public TyCoUser findByUserName(String userName);
}
