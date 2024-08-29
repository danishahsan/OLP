package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.ResponseCourseDto;
import com.example.demo.services.CourseService;

@RestController("course")
@RequestMapping("/course")
public class CourseController {

	CourseService service;
	
	public CourseController(CourseService service) {
		this.service = service;
	}


	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody CourseDto course){
		
		service.saveCourse(course);
		return new ResponseEntity<String>("Course added successfully",HttpStatus.OK); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addCourses(@RequestBody List<CourseDto> user){
		return new ResponseEntity<>(service.addCourses(user),HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ResponseCourseDto>> getAllCourses(){
		return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
		
		return new ResponseEntity<>(service.deleteCourse(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCourse(){
		
		return new ResponseEntity<>(service.updateCourse(null), HttpStatus.OK);
	}
	
}
