package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseStudentDataGetDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			Student student = session.get(Student.class, 4);
			System.out.println(student.getCourses());
			
			Course course = session.get(Course.class, 11);
			System.out.println(course.getStudents());
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
