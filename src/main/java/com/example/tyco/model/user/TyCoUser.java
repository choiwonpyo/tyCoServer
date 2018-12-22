package com.example.tyco.model.user;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.security.core.GrantedAuthority;

import com.example.tyco.model.oauth.users_authority.Authority;
import com.example.tyco.model.oauth.users_authority.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TyCoUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1832528131995817399L;

	@Getter
	@Setter
	@Id
	Long id;
	
	@Getter
	@Setter
	private String nickName;
	
	@Getter
	@Setter
	private Integer typingScore; //
	
	@Getter
	@Setter
	private Integer solvingStep;
	
	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private User user;
	
	public TyCoUser(String username, String password, String nickName, Collection<Authority> authorities) {
		this.user = new User(username, password, authorities);
		this.nickName = nickName;
		this.typingScore = 0;
		this.solvingStep = 0;
	}

}
