package com.buildwithkumar.cruddemo;

import com.buildwithkumar.cruddemo.dao.StudentDAO;
import com.buildwithkumar.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating 3 new student object.....");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@buildwithkumar.com");
		Student tempStudent2 = new Student("Mary", "Jane", "mary@buildwithkumar.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@buildwithkumar.com");

		//save the student object
		System.out.println("Saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		//display the id of the saved object
		System.out.println("Saved student1. Generating id: " + tempStudent1.getId());
		System.out.println("Saved student2. Generating id: " + tempStudent2.getId());
		System.out.println("Saved student3. Generating id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating the new student object.....");
		Student tempStudent = new Student("Paul", "Doe", "paul@buildwithkumar.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);
		//display the id of the saved object
		System.out.println("Saved student. Generating id: " + tempStudent.getId());
	}

}
