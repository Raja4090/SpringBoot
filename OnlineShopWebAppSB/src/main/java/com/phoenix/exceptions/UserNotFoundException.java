package com.phoenix.exceptions;

public class UserNotFoundException extends Exception {

	String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [msg=" + msg + "]";
	}
	
	
}
