package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;


@RestController("user")
@RequestMapping("/user")
public class UserController {

	UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}


	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return new ResponseEntity<>(service.saveUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUsers(@RequestBody List<User> user){
		return new ResponseEntity<>(service.addUsers(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser")
	public UserDto registerUser(@RequestParam("id")String UserId){
		
		User user = service.getUser(UserId);
		return new UserDto(user.getUserId(),user.getUserFirstName(),user.getUserLastName(),user.getUserEmail());
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		
		return new ResponseEntity<>(service.deleteUser(id), HttpStatus.OK);
	}
}
