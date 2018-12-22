package com.example.tyco.model.oauth.users_authority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_NAME" }) })
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	@Getter
	@Setter
    private Long id;

    @Column(name = "USER_NAME")
	@Getter
	@Setter
    private String username;

    @Column(name = "PASSWORD")
	@Getter
	@Setter
    private String password;

    @Column(name = "ACCOUNT_EXPIRED")
	@Getter
	@Setter
    private boolean accountExpired;

    @Column(name = "ACCOUNT_LOCKED")
	@Getter
	@Setter
    private boolean accountLocked;

    @Column(name = "CREDENTIALS_EXPIRED")
	@Getter
	@Setter
    private boolean credentialsExpired;

    @Column(name = "ENABLED")
	@Getter
	@Setter
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_AUTHORITIES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID"))
    @OrderBy
    @JsonIgnore
	@Getter
	@Setter
    private Collection<Authority> authorities;

    public User(String userName, String password, Collection<Authority> authorities) {
    	this.username = userName;
    	this.password = password;
    	this.accountExpired = false;
    	this.accountLocked = false;
    	this.credentialsExpired = false;
    	this.enabled = true;
    	this.authorities = authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }
}
