package com.example.demo.entity;

import java.security.Timestamp;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.utility.Level;
import com.example.demo.utility.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Review {
	
	@Id
	private String id;
	@ManyToOne
	private Course  course;
	@ManyToOne
	private User user;
	private Integer rating;
	private String comment;
	private Timestamp createdAt ;
	private Timestamp updatedAt ;

}
