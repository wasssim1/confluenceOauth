package com.confluence.test;

import static java.util.Objects.requireNonNull;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("serial")
public class ConfluenceUser implements UserDetails{
	
	 String id;
	 String username;
	 String shortname;
	 String password;
	 
	 @JsonCreator
	  void User(@JsonProperty("id") String id,
	       @JsonProperty("username") String username,
	       @JsonProperty("shortname") String shortname,
	       @JsonProperty("password") String password) {
	    super();
	    this.id = requireNonNull(id);
	    this.username = requireNonNull(username);
	    this.shortname = requireNonNull(shortname);
	    this.password = requireNonNull(password);
	  }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
