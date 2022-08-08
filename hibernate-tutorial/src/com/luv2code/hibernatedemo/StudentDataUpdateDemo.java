package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataUpdateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			int studentId = 1;
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setEmail("UpdateTestingOne@gmail.com");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("Update Student Set email = 'UpdateTestingBulk@gmail.com' Where firstName = 'Raj' or lastName = 'Raj'").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
