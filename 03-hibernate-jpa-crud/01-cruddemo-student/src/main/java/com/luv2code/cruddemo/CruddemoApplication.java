package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Lee", "Sin", "lol@riot.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student);

		// display id of the saved student
		int studentId = student.getId();
		System.out.println("Saved student. Generated id: " + studentId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple students");
		List<Student> students = new ArrayList<>();
		students.add(new Student("Test", "Last", "test@email.com"));
		students.add(new Student("XYZ", "ZYX", "XYZ@email.com"));
		students.add(new Student("Jolly", "Roger", "yarr@email.com"));

		System.out.println("Saving students");
		students.forEach(student -> {
			studentDAO.save(student);
			System.out.println("Saved student. Generated id: " + student.getId());
		});
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object.");
		Student student = new Student("A", "BC", "abc@email.com");

		// save the student object
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}
}