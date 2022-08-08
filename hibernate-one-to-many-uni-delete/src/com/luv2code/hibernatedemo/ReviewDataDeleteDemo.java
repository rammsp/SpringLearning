package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReviewDataDeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			Course course = session.get(Course.class, 10);
			session.delete(course);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
