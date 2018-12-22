package com.example.tyco.config.security;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@Configuration
//@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
	@Bean
	public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
		RowMapper<User> userRowMapper = (ResultSet rs, int i) -> 
		new User(rs.getString("ACCOUNT_NAME"),
				rs.getString("PASSWORD"), 
				rs.getBoolean("ENABLED"),
				 rs.getBoolean("ENABLED"),
				 rs.getBoolean("ENABLED"),
				 rs.getBoolean("ENABLED"),
				 AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
		return username -> jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?", userRowMapper, username);
	}
	
	@Autowired
	private UserDetailsService userDetailService;
	

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(this.userDetailService);
        auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return auth;
    }

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {	
		auth.authenticationProvider(authenticationProvider());
	}
}
