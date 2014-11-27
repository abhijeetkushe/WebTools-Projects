package com.webtools.springfinal.authorities;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityUser implements GrantedAuthority {

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_USER";
	}

}
