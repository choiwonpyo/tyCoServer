package com.example.tyco.service.register;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tyco.model.form.TyCoUserForm;
import com.example.tyco.model.oauth.users_authority.Authority;
import com.example.tyco.model.user.TyCoUser;
import com.example.tyco.repository.TyCoUserRepository;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{
	
	@Autowired
	private TyCoUserRepository tyCoUserRepository;
	
	@Autowired
	private AuthorityService authorityService;
	
    @Autowired
    private PasswordEncoder userPasswordEncoder;
    
	@Override
	public TyCoUser register(TyCoUser user) {
		if(tyCoUserRepository.findByUserUsername(user.getUser().getUsername()) != null) {
			throw new NullPointerException();
		}
		TyCoUser tyCo = tyCoUserRepository.save(user);
		
		return tyCo;
	}
	
	@Override
	public TyCoUser update(TyCoUser user) {
		TyCoUser loadUser = tyCoUserRepository.findByUserUsername(user.getUser().getUsername());
		if(loadUser == null) {
			throw new UsernameNotFoundException(user.getUser().getUsername());
		}
		tyCoUserRepository.save(user);
		return user;
	}
	@Override
	public TyCoUser findByUserName(String userName) {
		return this.tyCoUserRepository.findByUserUsername(userName);
	}

	@Override
	public TyCoUser makeTyCoUser(TyCoUserForm tyCoUser) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByName("FRONT_READ"));
		authorities.add(authorityService.findByName("FRONT_WRITE"));
		
		TyCoUser user = new TyCoUser(tyCoUser.getUserName(), userPasswordEncoder.encode(tyCoUser.getPassword()), tyCoUser.getNickName(), authorities);
		return user;
	}

}
