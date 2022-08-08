package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataReadDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student theStudent = new Student("Rahul", "Bhose", "RahulB@yahoo.co.in");
			System.out.println("We are about to save: " + theStudent.getId() + theStudent.getFirstName() + theStudent.getLastName() + theStudent.getEmail());
			session.beginTransaction();
			session.save(theStudent);
			session.getTransaction().commit();
			System.out.println("We have saved: " + theStudent.getId() + theStudent.getFirstName() + theStudent.getLastName() + theStudent.getEmail());

			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, theStudent.getId());
			session.getTransaction().commit();

			System.out.println("Student Retieved: " + myStudent.getId() + myStudent.getFirstName() + myStudent.getLastName() + myStudent.getEmail());

		} finally {
			factory.close();
		}

	}

}
