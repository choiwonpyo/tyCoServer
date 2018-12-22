package com.example.tyco.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalAuthentication
@Profile(value="memory")
public class InMemorySecurityConfiguration {

	@Autowired
	public void configureGolbal(AuthenticationManagerBuilder auth) throws Exception {
		String idForEncode = "bcrypt";
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("password");
		
		auth.inMemoryAuthentication()
		.withUser("user").password("{"+idForEncode +"}"+password).roles("USER")
		.and()
		.withUser("admin").password("{"+idForEncode +"}"+password).roles("USER", "ADMIN");
	}
}
