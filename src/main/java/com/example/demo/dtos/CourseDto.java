package com.example.demo.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {
	
	private Double coursePrice;
	private String courseCategory;
	private Serializable InstructorId;

}
