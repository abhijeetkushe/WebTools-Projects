package com.webtools.springfinal.bean;

import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

import com.webtools.generic.AbstractDTO;

public class UserAccountBean extends AbstractDTO{
	
	
	private Long accountID;
	@NotEmpty(message="No User Name is entered")
	private String userName;
	@NotEmpty(message="No Password is entered")	
	private String password;
	private Set<String> roles;
	@NotEmpty(message="No User type is entered")	
	private String userType;
	
	
	
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	/**
	  * @return the accountID
	 */
	public Long getAccountID() {
		return accountID;
	}
	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
}
