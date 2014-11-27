package com.webtools.springfinal.authorities;

import static com.webtools.springfinal.authorities.HealthCareConstants.*;

public enum HealthCareGrantedAuthority {
	ROLE_USER("ROLE_USER"), ROLE_DOCTOR("ROLE_DOCTOR"),ROLE_PATIENT("ROLE_PATIENT");

	private HealthCareGrantedAuthority(String roleName) {
		putGrantedAuthority(roleName, this);

	}

	public static HealthCareGrantedAuthority getHealthCareGrantedAuthority(
			String authrole) {
		return getGrantedAuthority(authrole);
	}
}
