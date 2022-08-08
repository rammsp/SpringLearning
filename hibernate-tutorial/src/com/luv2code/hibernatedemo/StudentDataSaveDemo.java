package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataSaveDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("Rama", "Moorthy", "ramsishu@gmail.com");
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
