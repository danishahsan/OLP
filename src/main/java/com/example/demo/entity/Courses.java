package com.example.demo.entity;


import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Courses {
	
	
	
//	public Course(Double coursePrice, String courseCategory, User courseInstructor) {
//		this();
//		this.coursePrice = coursePrice;
//		this.courseCategory = courseCategory;
//		this.courseInstructor = courseInstructor;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(
//	        name = "custom-generator",
//	        strategy ="com.example.demo.customGenerator",
//	        parameters = {
//	            @Parameter(name = "prefix", value = "course"),
//	            @Parameter(name = "numberFormat", value = "%05d") // Example parameter
//	        }
//	    )
	private Integer courseTitle;
	
	private Double coursePrice;
//	private String courseDescription;
//	private Double courseDuration;
	private String courseCategory;
	
//	@ManyToOne
//	@JoinColumn(name ="user_id")
//	private User courseInstructor;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp courseCreatedAt ;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private Timestamp courseUpdatedAt ;

}
