package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;

}
