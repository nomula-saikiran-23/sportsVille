package com.deepak.sportsville.controllers;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deepak.sportsville.services.*;

import jakarta.validation.Valid;

import com.deepak.sportsville.exceptions.GlobalExceptionHandler;
import com.deepak.sportsville.payloads.*;


@RestController
@RequestMapping("/api/users")

public class UserController {
	
	@Autowired
	private UserService userService;

	//creating user using post
	
	
//	@PostMapping("/")
//	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
//	{
//		UserDto createUserDto = this.userService.createUser(userDto);
//		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
//		
//	}

	
	
	@PostMapping("/")
	public ResponseEntity<Map<String,String>> createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
	   if (bindingResult.hasErrors()) {
	      // Get the validation errors and add them to a list
	      List<String> errors = bindingResult.getAllErrors()
	         .stream()
	         .map(DefaultMessageSourceResolvable::getDefaultMessage)
	         .collect(Collectors.toList());
	         
	      // Create a response object with the errors
	      Map<String, String> response = new HashMap<>();
	      response.put("status", "error");
	      response.put("message", "Validation failed");
	      response.put("errors", errors.toString());
	      
	      // Return a JSON response with the errors
	      return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
	   }
	   // Rest of the user creation code
	   
	   UserDto createUserDto = this.userService.createUser(userDto);
	   Map<String,String> validResponse = new HashMap<>();
	   validResponse.put("Status","User Created Sucessfully!!!");
	   return new ResponseEntity<Map<String,String>>(validResponse, HttpStatus.CREATED);
	}

	
	//put to update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId)
	{
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	//delete to delete the user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
}
