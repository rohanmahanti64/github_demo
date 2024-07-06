package com.demo.services;

import java.util.List;

import com.demo.payloads.UserDto;

public interface UserService {
// 
	// create user
	public UserDto createUser(UserDto userDto);
	// get single user 
	public UserDto getUser(Integer userId);
	// get all users 
	public List<UserDto> getAllUsers();
	// update user 
	public UserDto updateUser(UserDto userDto, Integer userId);
	// delete user
	public void deleteUser(Integer userId);
}
