package com.example.demo.entity;

import java.security.Timestamp;


import com.example.demo.utility.CompletionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//@Entity
@Data
public class Enrollment {
	
	@Id
	private String id;
	@ManyToOne
	private Course course;
	@ManyToOne
	private User user;
	private Timestamp enrollmentDate;
	private CompletionStatus completionStatus;
	private Timestamp createdAt ;
	private Timestamp updatedAt ;

}
