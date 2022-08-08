package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseDataAdd {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			Instructor instructor = new Instructor("Rama", "Moorthy", "Ramsishu@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("Java Coding Classes", "Java Coding");
			instructor.setInstructorDetail(instructorDetail);
			
			Course courseOne = new Course("Spring MVC 2");
			Course courseTwo = new Course("Spring Hibernate 2");
			Course courseThree = new Course("Spring AOP 2");
			
			instructor.addCourse(courseOne);
			instructor.addCourse(courseTwo);
			instructor.addCourse(courseThree);
			
			session.save(instructor);
			session.save(courseOne);
			session.save(courseTwo);
			session.save(courseThree);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
