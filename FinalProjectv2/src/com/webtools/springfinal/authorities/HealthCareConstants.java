package com.webtools.springfinal.authorities;

import java.util.HashMap;
import java.util.Map;

public abstract class HealthCareConstants {
private static final Map<String,HealthCareGrantedAuthority> GRANTED_AUTH=new HashMap<String,HealthCareGrantedAuthority>();
private static final Map<String,HealthCareGrantedAuthority> ROLE_TYPE=new HashMap<String,HealthCareGrantedAuthority>();
public static void putGrantedAuthority(String authKey,HealthCareGrantedAuthority grantedAuth)
{
	if(!GRANTED_AUTH.containsKey(authKey) && !GRANTED_AUTH.containsValue(grantedAuth))
	{
		GRANTED_AUTH.put(authKey,grantedAuth);
	}
	else
	{
		throw new IllegalArgumentException("Attempt to add Duplicate Key/Value in Map");
	}	
}

public static HealthCareGrantedAuthority getGrantedAuthority(String authKey)
{
	if(!GRANTED_AUTH.containsKey(authKey))
	{
		throw new IllegalArgumentException("AuthKey entered is invalid");
	}
	else
	{
		return GRANTED_AUTH.get(authKey);
	}
}	

/*public static void putRoleType(String roleType,HealthCareGrantedAuthority grantedAuth)
{
	if(!GRANTED_AUTH.containsKey(authKey) && !GRANTED_AUTH.containsValue(grantedAuth))
	{
		GRANTED_AUTH.put(authKey,grantedAuth);
	}
	else
	{
		throw new IllegalArgumentException("Attempt to add Duplicate Key/Value in Map");
	}	
}

public static HealthCareGrantedAuthority getGrantedAuthority(String authKey)
{
	if(!GRANTED_AUTH.containsKey(authKey))
	{
		throw new IllegalArgumentException("AuthKey entered is invalid");
	}
	else
	{
		return GRANTED_AUTH.get(authKey);
	}
}	
*/

}
