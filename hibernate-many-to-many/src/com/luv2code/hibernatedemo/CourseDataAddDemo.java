package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseDataAddDemo {

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
			Instructor instructor = new Instructor("Rama", "Moorthy", "Ramsishu@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("Java Coding Classes", "Java Coding");
			instructor.setInstructorDetail(instructorDetail);
			
			Student studentOne = new Student("Raq", "Kumar", "Raq@gmail.com");
			
			Course courseOne = new Course("Spring Hibernate - 1");
			Course courseTwo = new Course("Spring AOP - 1");

			instructor.addCourse(courseOne);
			instructor.addCourse(courseTwo);
			
			studentOne.add(courseOne);
			studentOne.add(courseTwo);
			
			session.save(instructor);
			session.save(studentOne);
			session.save(courseOne);
			session.save(courseTwo);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
