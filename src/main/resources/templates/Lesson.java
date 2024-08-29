package com.example.demo.entity;

import java.security.Timestamp;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.utility.Level;
import com.example.demo.utility.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lessonId;
	private String lessonTitle;
	private String lessonContent;
	private Double lessonDuration;
	@ManyToOne(fetch =FetchType.EAGER)
	private Course  lessonCourse;
	private Integer lessonOrder;
	private Timestamp lessonCreatedAt;
	private Timestamp lessonUpdatedAt;
	

}
