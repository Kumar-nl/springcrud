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
			createStudent(studentDAO);
		};
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
