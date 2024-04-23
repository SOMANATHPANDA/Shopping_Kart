package com.ty.shopapp.errorresponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError<T> {

	private T message;  // hold the excption message
	private LocalDateTime localdatetime; 	//date and time of exception
	private String path;	// in which endpoint the exception is generated 
	private HttpStatus httpStatus;	// status associated with exception
}
