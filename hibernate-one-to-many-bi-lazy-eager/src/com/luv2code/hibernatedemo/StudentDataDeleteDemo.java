package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataDeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int instDetailId = 6;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, instDetailId);
			tempInstructorDetail.getInstructor().setInstructorDetail(null);;
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
