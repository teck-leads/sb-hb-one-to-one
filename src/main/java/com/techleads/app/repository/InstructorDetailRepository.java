package com.techleads.app.repository;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techleads.app.model.Instructor;
import com.techleads.app.model.InstructorDetail;
import com.techleads.app.util.HibernateUtil;

public class InstructorDetailRepository {
	
	
	
	public void saveInstructorDetail(InstructorDetail instructorDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the InstructorDetail object
			// This will also save the Instructor object because of CascadeType.ALL
			
			//TODO it is not saving instructor id
			
			
//			Serializable save = session.save(instructorDetail);
			instructorDetail.getInstructor().setInstructorDetail(instructorDetail);
			session.persist(instructorDetail);
//			System.out.println(save.getClass() + "{}=>InstructorDetail saved!");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}


	public InstructorDetail findInstructorDetailsById(Integer id) {
		InstructorDetail instructorDetail = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			instructorDetail=session.get(InstructorDetail.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return instructorDetail;
	}
	
	
	public void deleteInstructorDetail(Integer id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			InstructorDetail instructordtl = session.get(InstructorDetail.class, id);
			System.out.println(instructordtl);
			if (null != instructordtl) {
				System.out.println("deleting now");
				//deleted object would be re-saved by cascade (remove deleted object from associations): [com.techleads.app.model.InstructorDetail#8]
				instructordtl.getInstructor().setInstructorDetail(null);
				
				session.delete(instructordtl);// This will also delete the Instructor object because of CascadeType.ALL
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
