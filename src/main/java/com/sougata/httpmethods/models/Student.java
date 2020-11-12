package com.sougata.httpmethods.models;

//import java.io.Serializable;

// implements Serializable

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
	long PRN, classroom, age;
	long phoneNumber;
	String firstName, lastName, address, division;
	Course[] coursesEnrolled = new Course[3];
	
	public Student(long PRN, long classroom, String firstName,
			String lastName, long age, String division,
				   long phoneNumber, String address,
			Course[] coursesEnrolled) {
		
//		super();
		this.PRN = PRN;
		this.classroom = classroom;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.division = division;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.coursesEnrolled = coursesEnrolled;
	}
	
	public String displayData(){
		//System.out.println(this.PRN);
//		return "pass";

		System.out.println("PRN: " + this.PRN);
		System.out.println("Name: " + this.firstName + " " +
				this.lastName);
		System.out.println("Class: " + this.classroom);
		System.out.println("Division: " + this.division);
		System.out.println("Age: " + this.age);
		System.out.println("Phone: " + this.phoneNumber);
		System.out.println("Address: " + this.address);
		System.out.println("Courses:");
		Arrays.stream(coursesEnrolled).forEach(e -> {
			System.out.println();
			System.out.println("Course ID: " + e.courseID);
			Arrays.stream(e.subjects).forEach(s -> {
				System.out.println("    " + s);
			});
		});

		return String.valueOf("PRN: " + this.PRN + "Name: "
		+ this.firstName + " " + this.lastName + "Course[2]: " +
				this.coursesEnrolled[2].courseID + " " +
				this.coursesEnrolled[2].subjects[3]);
	}

	public long getPhoneNumber(){
		return this.phoneNumber;
	}
}
