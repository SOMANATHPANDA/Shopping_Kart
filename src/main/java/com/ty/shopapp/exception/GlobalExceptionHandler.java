package com.ty.shopapp.exception;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.shopapp.errorresponse.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoProductfoundException.class)
	public ResponseEntity<?> handleProductIdNotFoundException(NoProductfoundException exception, HttpServletRequest req){
		
		ApiError<String> apierror = new ApiError();
		apierror.setMessage(exception.getMessage());
		apierror.setLocaldatetime(LocalDateTime.now());
		apierror.setHttpStatus(HttpStatus.NOT_FOUND);
		apierror.setPath(req.getServletPath());
		return new ResponseEntity<>(apierror,apierror.getHttpStatus());
	}
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<?> handleProductIdNotFoundException(ProductIdNotFoundException exception, HttpServletRequest req){
		ApiError<String> apierror = new ApiError();
		apierror.setMessage(exception.getMessage());
		apierror.setLocaldatetime(LocalDateTime.now());
		apierror.setPath(req.getServletPath());
		apierror.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apierror,apierror.getHttpStatus());
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<?> handleCompanyNotFound(CompanyNotFoundException exception, HttpServletRequest req){
		ApiError<String> apierror = new ApiError();		apierror.setMessage(exception.getMessage());
		apierror.setLocaldatetime(LocalDateTime.now());
		apierror.setPath(req.getServletPath());
		apierror.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apierror,apierror.getHttpStatus());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception, HttpServletRequest req){
		Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
		
		Set<String> strings = new HashSet<>();
		for(ConstraintViolation<?> constraintViolation : constraintViolations) {
			String message = constraintViolation.getMessage();
			strings.add(message);
		}
		
		ApiError<Set<String>> apiError = new ApiError();
		apiError.setMessage(strings);
		apiError.setPath(req.getServletPath());
		apiError.setLocaldatetime(LocalDateTime.now());
		apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
	}
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<?> handleCustomerIdNotFoundException(CustomerIdNotFoundException exception, HttpServletRequest req){
		ApiError<String> apierror = new ApiError();
		apierror.setMessage(exception.getMessage());
		apierror.setLocaldatetime(LocalDateTime.now());
		apierror.setPath(req.getServletPath());
		apierror.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apierror,apierror.getHttpStatus());
	}
	
	@ExceptionHandler(CustomerEmailIdNotFoundException.class)
	public ResponseEntity<?> handleCustomerEmailIdNotFoundException(CustomerEmailIdNotFoundException exception, HttpServletRequest req){
		ApiError<String> apierror = new ApiError();
		apierror.setMessage(exception.getMessage());
		apierror.setLocaldatetime(LocalDateTime.now());
		apierror.setPath(req.getServletPath());
		apierror.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apierror,apierror.getHttpStatus());
	}
}