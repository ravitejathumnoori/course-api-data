package com.course.springbootstarter.topic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.data.repository.cdi.Eager;

import com.course.springbootstarter.course.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Topic {
	
	@Id
	@Pattern(regexp="^[a-z]*$",message = "Invalid Input")//shouldn't start with small
	private String id;
	@Pattern(regexp="^[a-z]*$",message = "Invalid Input")//shouldn't start with small
	private String name;
	private String description;
	@JoinColumn(name = "parent_id")
	@OneToMany
	@JsonManagedReference
	private List<Course> courses;
	
	public Topic() {
	}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
