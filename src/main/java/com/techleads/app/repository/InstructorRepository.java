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

	public void saveInstructor(Instructor instructor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			// This will also save the details object because of CascadeType.ALL
			Serializable save = session.save(instructor);
			System.out.println(save.getClass() + " Instructor and detail are saved!");
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
				session.delete(instructor);// This will also delete the Instructordetails object because of CascadeType.ALL
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
	
	
	public void updateInstructor(Integer id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			// This will also save the details object because of CascadeType.ALL
//			String SQL="update instructor set instructor_detail_id = "+id+" where id = 8 or id = 9";
			String SQL="update instructor set instructor_detail_id = 9 where id = 8 or id = 9";
//			int executeUpdate = session.createQuery("update student set email='emp@tm.com'").executeUpdate();
			int executeUpdate = session.createQuery(SQL).executeUpdate();
			System.out.println(executeUpdate+" Instructor and detail are saved!");
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
