package com.webtools.springfinal.service.exception;

public class AppointmentServiceException extends Exception {

private String message;
	
	public AppointmentServiceException(String message)
	{
		super(message);
		this.message=message;		
	}
}
