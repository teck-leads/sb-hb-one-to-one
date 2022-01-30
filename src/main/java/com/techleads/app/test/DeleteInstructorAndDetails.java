package com.techleads.app.test;

import com.techleads.app.repository.InstructorRepository;

public class DeleteInstructorAndDetails {
	private static InstructorRepository instructorRepository=new InstructorRepository();
	public static void main(String[] args) {
		
		
		instructorRepository.deleteInstructor(6);

	}

}
