package com.techleads.app.test;

import com.techleads.app.model.Instructor;
import com.techleads.app.model.InstructorDetail;
import com.techleads.app.repository.InstructorDetailRepository;

public class SaveInstructorDetail {
private static InstructorDetailRepository instructorDetailRepository=new InstructorDetailRepository();
	public static void main(String[] args) {
		
		Instructor instructor=new Instructor("newinsdtl", "insdtl", "dtl@tm.com");
		InstructorDetail dtl=new InstructorDetail("http://drawing/youtube/insdtl", "newlisting music");
		instructor.setInstructorDetail(dtl);
		dtl.setInstructor(instructor);
		
		instructorDetailRepository.saveInstructorDetail(dtl);
		

	}

}
