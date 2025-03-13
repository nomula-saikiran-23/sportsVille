package com.deepak.sportsville.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deepak.sportsville.payloads.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
		//we get the message from userimpl as we mentioned the string
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> resp =new HashMap<>();
		
		ex.getBindingResult().getGlobalErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
		});
		
		
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	//for the data integrity exceptions
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleSQLIntegrity(DataIntegrityViolationException ex)
	{
//		Throwable cause = ex.getCause();
//	    if (cause instanceof ConstraintViolationException) {
//	        ConstraintViolationException cve = (ConstraintViolationException) cause;
//	        String constraintName = cve.getConstraintName();
//	        // You can use the constraintName to identify which constraint was violated.
//	        // For example, you can log it or return it as part of the error message.
//	    }
		
		return new ResponseEntity<String>("Data integrity violation occurred: "+ ex.getMostSpecificCause().getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
