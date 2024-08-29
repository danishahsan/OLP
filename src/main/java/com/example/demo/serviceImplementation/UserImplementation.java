package com.example.demo.serviceImplementation;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UserService;

@Service
public class UserImplementation implements UserService
{
	private UserRepo repo;
	
	public UserImplementation(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public User getUser(Serializable id) {
		
		return (User)repo.getReferenceById(id);
	}

	@Override
	public String updateUser(Integer id) {
		return null;
	}

	@Override
	public String deleteUser(String id) {
		repo.deleteById(id);
		return "Sucessfully Deleted";
	}

	@Override
	public String save() {
		
		User user = new User();
		System.out.println(user.getUserFirstName()+" is not null");
		repo.save(user);
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		return repo.findAll().stream()
                .map(user -> new UserDto(user.getUserId(), user.getUserFirstName(), user.getUserLastName(),user.getUserEmail()))
                .collect(Collectors.toList());
	}

	@Override
	public String addUsers(List<User> users) {
		repo.saveAll(users);
		return "Addes Successfully";
	}


}
