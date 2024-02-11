package com.Ecommerce.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
    @ExceptionHandler(InvalidProductException.class)
	public ResponseEntity<ErrorInfo> invalidpriceexp(InvalidProductException exeption){
    	ErrorInfo errorInfo = new ErrorInfo();
    	errorInfo.setErrorMessage(exeption.getmsg());
    	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
    	errorInfo.setLocalDateTime(LocalDateTime.now());
    	
    	
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
		
	}
    
    @ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorInfo> idnotFoundExp(InvalidUserException idNotFoundExceotion){
    	ErrorInfo errorInfo = new ErrorInfo();
    	errorInfo.setErrorMessage(idNotFoundExceotion.getmsg());
    	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
    	errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
    
    @ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> idnotFoundExp(UserNotFoundException idNotFoundExceotion){
    	ErrorInfo errorInfo = new ErrorInfo();
    	errorInfo.setErrorMessage(idNotFoundExceotion.getmsg());
    	errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
    	errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
    

}
