package com.example.tyco.model.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.security.core.GrantedAuthority;

import com.example.tyco.model.oauth.users_authority.Authority;
import com.example.tyco.model.oauth.users_authority.User;
import com.example.tyco.model.study.TypingStep;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@OneToOne(fetch = FetchType.EAGER)
    @MapsId
	private User user;
	

    @OneToMany(
        mappedBy = "tyCoUser",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @Getter
    @Setter
    @JsonManagedReference
    private List<TypingStepUserStudy> typingStepUserStudy = new ArrayList<>();
 
	public TyCoUser(String username, String password, String nickName, Collection<Authority> authorities) {
		this.user = new User(username, password, authorities);
		this.nickName = nickName;
		this.typingScore = 0;
		this.solvingStep = 0;
	}

}
