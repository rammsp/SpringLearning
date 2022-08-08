package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataDeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			Student myStudentOne = new Student("DelFirstNameOne", "DelLastNameOne", "DelEmailOne");
			Student myStudentTwo = new Student("DelFirstNameTwo", "DelLastNameTwo", "DelEmailTwo");
			session.beginTransaction();
			session.save(myStudentOne);
			session.save(myStudentTwo);
			session.getTransaction().commit();
			
			//Add breakpoint in below step and see updates in DB
			int studentId = myStudentOne.getId();
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student delStudent = session.get(Student.class, studentId);
			session.delete(delStudent);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("Delete from Student where lastName = 'DelLastNameTwo'").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
