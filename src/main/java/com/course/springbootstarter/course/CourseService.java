package com.course.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.springbootstarter.exception.CourseNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	 
	public List<Course> getAllCourses(String topicId) {
		//return topics;
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(Optional<Course> id,String error) {
		id.orElseThrow(() -> new CourseNotFoundException("Not found: " + error));
		courseRepository.delete(id.get());
	}

	
}
