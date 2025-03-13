package com.deepak.sportsville.services;
import java.util.*;
import com.deepak.sportsville.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	void deleteUser(Integer userId);
	
}
