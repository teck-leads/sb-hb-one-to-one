package com.techleads.app.repository;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Instructor;
import com.techleads.app.model.InstructorDetail;
import com.techleads.app.util.HibernateUtil;

@Repository
public class InstructorRepository {

	public void saveInstructor(Instructor instructor, InstructorDetail instructorDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			// This will also save the details object because of CascadeType.ALL
			Serializable save = session.save(instructor);
			System.out.println(save.getClass() + " saved!");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void deleteInstructor(Integer id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, id);
			System.out.println(instructor);
			if (null != instructor) {
				System.out.println("deleting now");
				session.delete(instructor);// This will also save the details object because of CascadeType.ALL
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

	public Instructor findInstructorById(Integer id) {
		Instructor instructor = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			instructor = session.get(Instructor.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return instructor;
	}

}
