package com.example.demo.services;

import java.io.Serializable;
import java.util.List;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.User;

public interface UserService {

	String save();
	User saveUser(User user);
	User getUser(Serializable serializable);
	List<UserDto> getAllUsers();
	String updateUser(Integer id);
	String deleteUser(String id);
	String addUsers(List<User> users);
}
