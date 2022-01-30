package com.techleads.app.test;

import com.techleads.app.model.Instructor;
import com.techleads.app.model.InstructorDetail;
import com.techleads.app.repository.InstructorRepository;

public class SaveInstructor {
private static InstructorRepository instructorRepository=new InstructorRepository();
	public static void main(String[] args) {
		
		Instructor instructor=new Instructor("teja", "teja", "teja@tm.com");
		InstructorDetail dtl=new InstructorDetail("http://drawing/youtube", "listing music");
		instructor.setInstructorDetail(dtl);
		instructorRepository.saveInstructor(instructor);
		

	}

}
