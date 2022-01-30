package com.techleads.app.test;

import com.techleads.app.repository.InstructorDetailRepository;

public class DeleteInstructorDetails {
	private static InstructorDetailRepository instructorDetailRepository = new InstructorDetailRepository();

	public static void main(String[] args) {
//		InstructorDetail findInstructorDetailsById = instructorDetailRepository.findInstructorDetailsById(8);
//		System.out.println(findInstructorDetailsById);

		instructorDetailRepository.deleteInstructorDetail(8);
	}

}
