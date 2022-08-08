package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataGetDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			int instDetailId = 4;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, instDetailId);
			session.getTransaction().commit();
			System.out.println(tempInstructorDetail);
			System.out.println(tempInstructorDetail.getInstructor());
		} finally {
			factory.close();
		}
		
	}

}
