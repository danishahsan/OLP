package com.example.demo.serviceImplementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.ResponseCourseDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.repositories.CourseRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CourseService;
import com.example.demo.services.UserService;

@Service
public class CourseImplementation implements CourseService
{
	private CourseRepo courseRepo;
	private UserService	uService;
	private UserRepo userRepo;
	
	public CourseImplementation(CourseRepo courseRepo, UserService uService,UserRepo userRepo) {
		this.uService=uService;
		this.courseRepo = courseRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void saveCourse(CourseDto course) {
		User user = uService.getUser(course.getInstructorId());
		Course course2 = new Course((Double)course.getCoursePrice(),course.getCourseCategory(),user);
		courseRepo.save(course2);
	}

	@Override
	public CourseDto getCourse(Integer id) {
		return null;
	}

	@Override
	public String updateCourse(Integer id) {
		
		courseRepo.getReferenceById(id).setCourseInstructor(null);;
		return null;
	}

	@Override
	public String deleteCourse(Integer id) {
		courseRepo.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public String save() {
		
		return null;
	}

	@Override
	public List<ResponseCourseDto> getCourses() {
		return courseRepo.findAll().stream().map(course->new ResponseCourseDto(course.getCourseTitle(),
				 course.getCourseInstructor().getUserFirstName(), course.getCourseCategory(),
				course.getCoursePrice())).collect(Collectors.toList());
	}

	@Override
	public String addCourses(List<CourseDto> courses) {
		
		List<Serializable> collect2 = courses.stream().map(course->course.getInstructorId()).collect(Collectors.toList());
		List<User> users = userRepo.findAllById(collect2);
		List<Course> crs=new ArrayList<>();
		
//		users.forEach(s->System.out.println(s.getUserFirstName()));
//		courses.stream().map(course->course.setCourseInstructor(course.get))
		
//		List<Course> collect = courses.stream().map(course->
//		users.stream().map(user->course.setCourseInstructor(user))).collect(Collectors.toList());
		
//		.collect(Collectors.toList());
//		int i=0;
//		courses.forEach(course->crs.add(new Course(course.getCoursePrice(),course.getCourseCategory(),users.get(i++))));
		

//		courses.stream().map(course->new Course(course.getCoursePrice(),course.getCourseCategory(),course.getInstructorId())).collect(Collectors.toList());
		
//		courses.stream().map(course->users.stream().map(user->new Course(course.getCoursePrice(),course.getCourseCategory(),user))).collect(Collectors.toList());
		
		
//		int k=0;
//		for(int i=0,j=0;i<users.size();i++,j++) {
//			crs.add(new Course(courses.get(i).getCoursePrice(),courses.get(i).getCourseCategory(),users.get(k++)));
//		}
//		
//		 Map<String, User> userMap = users.stream()
//	                .collect(Collectors.toMap(user -> user.getUserId(), user -> user));
//
//	        // Step 3: Create and save Course entities without using method references
//			/*
//			 * List<Course> crs = courses.stream() .map(courseDto -> { Double price =
//			 * courseDto.getCoursePrice(); String category = courseDto.getCourseCategory();
//			 * User instructor = userMap.get(courseDto.getInstructorId()); return new
//			 * Course(price, category, instructor); }) .collect(Collectors.toList());
//			 */
		courseRepo.saveAll(crs);
		return "Sucessfully added";
	}

	@Override
	public String delete() {
		courseRepo.deleteAll();
		return "Successfully Deleted";
	}

}
