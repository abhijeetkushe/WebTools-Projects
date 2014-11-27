package com.webtools.springfinal.authorities;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityDoctor implements GrantedAuthority {

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_DOCTOR";
	}

}
