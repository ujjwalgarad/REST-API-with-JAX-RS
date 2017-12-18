package org.ujjwal.RESTAPIpractice.messenger.exception;

public class DataNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 4576758592526593685L;

	public DataNotFoundException(String message){
		super(message);
	}
}
