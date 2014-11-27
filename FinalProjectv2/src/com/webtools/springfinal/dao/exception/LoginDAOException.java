package com.webtools.springfinal.dao.exception;

public class LoginDAOException extends Exception {

	private String message;
	
	public LoginDAOException(String message)
	{
		super(message);
		this.message=message;		
	}
}
