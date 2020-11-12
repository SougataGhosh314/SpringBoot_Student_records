package com.sougata.httpmethods.models;

import java.io.Serializable;

public class Course implements Serializable {
	long courseID;
	String[] subjects = new String[5];
	
	public Course(long courseID, String[] subjects) {
		this.courseID = courseID;
		
		for(int i=0;i<5;i++) {
			this.subjects[i] = subjects[i];
		}
	}
}
