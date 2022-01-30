package com.techleads.app.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techleads.app.model.InstructorDetail;
import com.techleads.app.util.HibernateUtil;

public class InstructorDetailRepository {

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
	
	
	public void deleteInstructorInstructorDetail(Integer id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			InstructorDetail instructordtl = session.get(InstructorDetail.class, id);
			System.out.println(instructordtl);
			if (null != instructordtl) {
				System.out.println("deleting now");
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
