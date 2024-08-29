package com.example.demo.entity;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	private String id;
	private String name;
	private String description;
	private Timestamp createdAt ;
	private Timestamp updatedAt ;
	
}
