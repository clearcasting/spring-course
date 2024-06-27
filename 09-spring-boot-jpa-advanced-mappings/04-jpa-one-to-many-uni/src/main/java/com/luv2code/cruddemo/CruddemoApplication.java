package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course");
		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Score One Million Points");

		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done."));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);

		course.setTitle("Enjoy the Simple Things");
		appDAO.update(course);

		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setLastName("TESTER");

		appDAO.update(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println(instructor.getInstructorDetail());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

		InstructorDetail instructorDetail =
				new InstructorDetail(
						"Video Games",
						"http://www.youtube.com");

		instructor.setInstructorDetail(instructorDetail);

		Course course = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course);
		instructor.add(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		appDAO.save(instructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detail id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done deleting");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Deleting instructor id: " + id);
		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("The associate instructorDetail only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//		InstructorDetail instructorDetail =
//				new InstructorDetail(
//				"http://www.luv2code.com/youtube",
//				"Luv 2 code!!!");

		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail instructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		instructor.setInstructorDetail(instructorDetail);

		// this will also save the details object
		// because of CascadeType.ALL

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}

}
