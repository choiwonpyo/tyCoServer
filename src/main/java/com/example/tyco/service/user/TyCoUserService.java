package com.example.tyco.service.user;

import java.util.Optional;

import com.example.tyco.model.user.TyCoUser;

public interface TyCoUserService {

	Optional<TyCoUser> getTyCoUserById(Long id);

	TyCoUser getTyCoUserByUserName(String userName);

}
