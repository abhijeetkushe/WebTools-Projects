package com.webtools.springfinal.dao.exception;

public class AppointmentDAOException extends Exception {

	public AppointmentDAOException(String message) {
		super(message);
	}
	
	public AppointmentDAOException(Exception e) {
		super(e);
	}
}
