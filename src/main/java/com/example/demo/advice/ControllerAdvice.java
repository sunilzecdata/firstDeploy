package com.example.demo.advice;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.custom.exception.BusinessException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{	
	
	
//	@ExceptionHandler(NullPointerException.class)
//	public ResponseEntity<String> handleEmptyInput(NullPointerException nullPointerException)
//	{
//		return new ResponseEntity<String>("input field empty ",HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<String> handleNullPointer(EntityNotFoundException entityNotFoundException)
//	{
//		return new ResponseEntity<String>("No Entry Found",HttpStatus.NOT_FOUND);
//	}
//	
//	@Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		// TODO Auto-generated method stub
//		return new ResponseEntity<Object>("Please change http method type", HttpStatus.NOT_ACCEPTABLE);
//	}
//	
	
}
