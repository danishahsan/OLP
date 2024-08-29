package com.example.demo.entity;


import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(generator = "user_id_generator")
	@GenericGenerator(name = "user_id_generator", type =com.example.demo.customGenerator.UserIdGenerator.class)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPassword;
	
	@OneToMany(mappedBy = "courseInstructor", cascade = CascadeType.ALL)
	private List<Course> courses;
	
	@CreationTimestamp()
	@Column(updatable = false)
	private Timestamp userCretedAt;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private Timestamp userUpdatedAt;

}
