package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CourseNotFoundException;
import com.model.Course;
import com.service.CourseService;

@RestController
public class CourseController {

	// include the appropraiate annotation
	@Autowired
	private CourseService courseService;

//include the appropriate annotation
	@GetMapping("/cms/find/{courseId}")
	public Course findCourse(@PathVariable Integer courseId) {

//include the appropriate business logic	
		if (courseService.searchCourse(courseId) != null) {
			return courseService.searchCourse(courseId);
		} else {

			throw new CourseNotFoundException("No such course id");

		}
	}
}