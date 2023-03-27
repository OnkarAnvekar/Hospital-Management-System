package com.hms.custom_exception;

@SuppressWarnings("serial")
public class NoSuchEmployeeExistsException extends RuntimeException {
	public NoSuchEmployeeExistsException(String msg) {
		super(msg);
	}

}
