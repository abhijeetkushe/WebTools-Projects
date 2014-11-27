package com.webtools.springfinal.service.exception;

public class LoginServiceException extends Exception {
	
	private String message;
	
	public LoginServiceException(String message)
	{
		super(message);
		this.message=message;		
	}
}
