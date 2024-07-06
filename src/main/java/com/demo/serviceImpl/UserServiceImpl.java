package com.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.payloads.UserDto;
import com.demo.repository.UserRepository;
import com.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userRepository.save(this.modelMapper.map(userDto, User.class));
		UserDto updatedUser = this.modelMapper.map(user, UserDto.class);
		return updatedUser;
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()->
		new ResourceAccessException("User Not Found of user-id : "+userId));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = this.userRepository.findAll().stream().map(user-> 
		this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()->
			new ResourceNotFoundException("User Not Found with user-id : "+userId));
		user.setName(userDto.getName());
		user.setRole(userDto.getRole());
		User updatedUser = this.userRepository.save(user);
		UserDto updatedUserDto = this.modelMapper.map(updatedUser, UserDto.class);
		return updatedUserDto;
	}

	@Override
	public void deleteUser(Integer userId) {
       User user = this.userRepository.findById(userId).orElseThrow(() ->
       new ResourceNotFoundException("User Not Found with user-id : "+userId));
       this.userRepository.delete(user);
	}

}
