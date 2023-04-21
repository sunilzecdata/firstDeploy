package com.example.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public BusinessException(String message)
	{
		super(message);
	}
	
	public BusinessException()
	{
		super();
	}
}
