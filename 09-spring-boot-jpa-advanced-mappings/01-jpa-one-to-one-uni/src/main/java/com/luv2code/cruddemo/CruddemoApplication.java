package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
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
