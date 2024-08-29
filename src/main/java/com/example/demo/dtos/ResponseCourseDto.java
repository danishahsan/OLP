package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCourseDto {
	
	private Integer courseTitle;
	private String InstructorName;
	private String courseCategory;
	private Double coursePrice;

}
