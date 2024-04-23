package com.ty.shopapp.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
}
