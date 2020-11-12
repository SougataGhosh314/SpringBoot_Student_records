package com.sougata.httpmethods.controllers;

//import org.springframework.stereotype.Controller;
import com.sougata.httpmethods.models.Student;
import com.sougata.httpmethods.models.TestModel;
import com.sougata.httpmethods.services.DAOImpl;
import com.sougata.httpmethods.services.Service;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@RestController
public class homeController {

	@Value("${filePath}")
	public String filePath;

	//trying autowiring
	@Autowired
	Service service;

	@Autowired
	DAOImpl dao;

	@RequestMapping(value = "/createStudent", 
			method = RequestMethod.POST,
			consumes = "application/json")
	@ResponseBody
	public String createStudent(@RequestBody Student tm) {

		HashMap<Long, Student> hashMap =
				new HashMap<Long, Student>();

		//String path = "Students.txt";
		try {
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
			hashMap = (HashMap<Long, Student>) in.readObject();
			in.close();
//			System.out.println("Read Successful: ");
//			System.out.println(tm.displayData());
		}catch (Exception e){
			e.printStackTrace();
		}

		hashMap.put(tm.getPhoneNumber(), tm);

//		@Value("${}")
//		String path = "Students.txt";
		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(hashMap);
			out.close();
			System.out.println("Write Successful.");
		}catch (Exception e){
			e.printStackTrace();
		}

		return tm.displayData();

		//return student.toString();
		//return String.valueOf(student.getSomeFields());
	}

	@RequestMapping(value = "/viewStudentById",
			method = RequestMethod.GET)
	@ResponseBody
	public String viewStudentById(@RequestParam Long phoneNumber) {
		System.out.println(phoneNumber);
		HashMap<Long, Student> hashMap =
				new HashMap<Long, Student>();

		//String path = "Students.txt";
		try {
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
			hashMap = (HashMap<Long, Student>) in.readObject();
			in.close();
			System.out.println("Read Successful: ");
//			System.out.println(tm.displayData());
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println(hashMap.get(phoneNumber).displayData());
		return null;
	}

	@RequestMapping(value = "/viewAllStudents", method = RequestMethod.GET)
	public String viewAllStudents() {

		System.out.println(filePath);
		service.ServiceMethod();
		dao.DAOMethod();

		HashMap<Long, Student> hashMap =
				new HashMap<Long, Student>();

		//String path = "Students.txt";
		try {
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
			hashMap = (HashMap<Long, Student>) in.readObject();
			in.close();
			System.out.println("Read Successful: ");
//			System.out.println(tm.displayData());
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("----------Reading...------------");

		hashMap.forEach((key, value) -> {
			System.out.println("=======================");
			System.out.println(value.displayData());
		});

		return String.valueOf(hashMap);
	}

	@RequestMapping(value = "/deleteStudent",
					method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@RequestParam Long phoneNumber) {
		HashMap<Long, Student> hashMap =
				new HashMap<Long, Student>();

		//String path = "Students.txt";
		try {
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
			hashMap = (HashMap<Long, Student>) in.readObject();
			in.close();
//			System.out.println("Read Successful: ");
//			System.out.println(tm.displayData());
		}catch (Exception e){
			e.printStackTrace();
		}

		hashMap.remove(phoneNumber);

		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(hashMap);
			out.close();
			System.out.println("Delete Successful.");
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/updateStudent",
			method = RequestMethod.POST,
			consumes = "application/json")
	@ResponseBody
	public String updateStudent(@RequestBody Student tm) {
		HashMap<Long, Student> hashMap =
				new HashMap<Long, Student>();

		//String path = "Students.txt";
		try {
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
			hashMap = (HashMap<Long, Student>) in.readObject();
			in.close();
//			System.out.println("Read Successful: ");
//			System.out.println(tm.displayData());
		}catch (Exception e){
			e.printStackTrace();
		}

		hashMap.remove(tm.getPhoneNumber());
		hashMap.put(tm.getPhoneNumber(), tm);
		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(hashMap);
			out.close();
			System.out.println("Update Successful.");
		}catch (Exception e){
			e.printStackTrace();
		}

		return tm.displayData();

		//return null;
	}
}

/*
JSON data
{
    "PRN": 101,
    "classroom": 12,
    "firstName": "Raj",
    "lastName": "Kumar",
    "age": 22,
    "division": "Computer Science",
    "gender": "M",
    "phoneNumber": 7798456123,
    "address": "Pune",
    "coursesEnrolled": [
        {
            "courseID": 301,
            "subjects": [
                "OOP",
                "Databases",
                "Computer Networks",
                "Hardware",
                "Russian"
            ]
        },
        {
            "courseID": 302,
            "subjects": [
                "OOP",
                "Databases",
                "Computer Networks",
                "Hardware",
                "Spanish"
            ]
        },
        {
            "courseID": 303,
            "subjects": [
                "OOP",
                "Databases",
                "Computer Networks",
                "Hardware",
                "Algorithms"
            ]
        }
    ]

}


{
    "name": "Stannis Baratheon",
    "phoneNumber": 7234567898,
    "friend": {
        "name": "I have no friend.",
        "phoneNumber": 8798999999
    }
}

 */
