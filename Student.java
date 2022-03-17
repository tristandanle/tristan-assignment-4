/* 
 * Author: Tristan Dan Le
 * Subjet: assignmen-4
 * 
 * */
package com.codercampus.assignment4;

public class Student  {
	private String id;
	private String name;
	private String course;
	private Integer grade;

	public Student() {
    System.out.println("Student created");
	}

	public Student(String id, String name, String course, Integer grade) {

		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
	

	
}
