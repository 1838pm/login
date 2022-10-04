package com.example.demo.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String message;
	
	public CustomException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
		this.message = errorCode.getMessage();
	}

	public CustomException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
	}
}
