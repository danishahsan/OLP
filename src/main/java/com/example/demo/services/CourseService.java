package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.ResponseCourseDto;
import com.example.demo.entity.Course;

public interface CourseService {

	String save();
	void saveCourse(CourseDto course);
	String addCourses(List<CourseDto> courses);
	CourseDto getCourse(Integer id);
	List<ResponseCourseDto> getCourses();
	
	String updateCourse(Integer id);
	String deleteCourse(Integer id);
	String delete();
	
}
