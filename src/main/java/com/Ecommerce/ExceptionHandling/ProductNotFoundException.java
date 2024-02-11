package com.Ecommerce.ExceptionHandling;

public class ProductNotFoundException extends RuntimeException{
	
public String message;
	
	public ProductNotFoundException(String message) {
		super(message);
		this.message = message;
		
	}
	public String getmsg() {
		return message;
	}

}
