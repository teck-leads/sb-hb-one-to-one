package com.techleads.app.test;

import com.techleads.app.model.Instructor;
import com.techleads.app.repository.InstructorRepository;

public class ReadInstructor {
	private static InstructorRepository instructorRepository=new InstructorRepository();
	public static void main(String[] args) {
		
		
		Instructor findInstructorById = instructorRepository.findInstructorById(3);
		System.out.println(findInstructorById);
		System.out.println(findInstructorById.getInstructorDetail());
		

	}
}
