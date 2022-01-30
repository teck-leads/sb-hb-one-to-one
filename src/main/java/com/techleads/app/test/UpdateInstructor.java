package com.techleads.app.test;

import com.techleads.app.repository.InstructorRepository;

public class UpdateInstructor {
private static InstructorRepository instructorRepository=new InstructorRepository();
	public static void main(String[] args) {
		
	
		instructorRepository.updateInstructor(9);
		

	}

}
