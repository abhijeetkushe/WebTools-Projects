package com.webtools.springfinal.service.exception;

public class InvalidLoginException extends Exception {

	private String message;
	
	public InvalidLoginException(String message)
	{
		super(message);
		this.message=message;		
	}
}
