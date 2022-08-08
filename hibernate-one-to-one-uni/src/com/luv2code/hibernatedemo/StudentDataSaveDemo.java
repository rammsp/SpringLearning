package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataSaveDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor1 = new Instructor("Ramaa", "Moorthya", "ramsishusa@gmail.com");
			Instructor instructor2 = new Instructor("Raja", "Kumara", "raja@gmail.com");
			
			InstructorDetail instructorDetail1 = new InstructorDetail("www.ram.com", "Coding");
			InstructorDetail instructorDetail2 = new InstructorDetail("www.raj.com", "Dating");
			
			instructor1.setInstructorDetail(instructorDetail1);
			instructor2.setInstructorDetail(instructorDetail2);
			
			session.beginTransaction();			
			System.out.println("Saving: " + instructor1 + instructorDetail1);
			session.save(instructor1);
			System.out.println("Saving: " + instructor2 + instructorDetail2);
			session.save(instructor2);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
