package com.techleads.app.test;

import com.techleads.app.model.InstructorDetail;
import com.techleads.app.repository.InstructorDetailRepository;

public class ReadInstructorDetailsBiDirection {
	private static InstructorDetailRepository instructorDetailRepository = new InstructorDetailRepository();

	public static void main(String[] args) {
		InstructorDetail findInstructorDetailsById = instructorDetailRepository.findInstructorDetailsById(3);
		System.out.println(findInstructorDetailsById);
		System.out.println("Instructor details " + findInstructorDetailsById.getInstructor());

	}

}
