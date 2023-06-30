package com.springdemo.cruddemo;

import com.springdemo.cruddemo.dao.StudentDAO;
import com.springdemo.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {

			//createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//getAllStudents(studentDAO);

			//updateInfo(studentDAO);

			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting the Student ... ");
		studentDAO.delete(3);
	}

	private void updateInfo(StudentDAO studentDAO) {
		System.out.println("Updating Student Info ... ");
		Integer numRowsUpdated = studentDAO.update("Mahajan");
		System.out.println("Number of rows impacted = " + numRowsUpdated);

	}

	private void getAllStudents(StudentDAO studentDAO) {
		System.out.println("Fetching all the Student");
		List<Student> studentList =  studentDAO.findAll();
		for(Student individualStudent : studentList){
			System.out.println(individualStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new Student");
		Student newStudent = new Student("Pragati", "Manchanda","pragati@gmail.com");

		System.out.println("Saving a new Student");
		studentDAO.save(newStudent);

		System.out.println("New Student ID is : " + newStudent.getId());

		Student savedStudent = studentDAO.findByID(newStudent.getId());
		System.out.println("Retrieved Student is : " + savedStudent);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new Student");
		Student newStudent;
		newStudent = new Student("Anuj", "Mahajan","anujsmahajan98@gmail.com");

		System.out.println("Saving a new Student");
		studentDAO.save(newStudent);

		System.out.println("Saved student ID " + newStudent.getId());

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 new Student");
		Student newStudent1 = new Student("Tanmay", "Mahindrakar","tammy@gmail.com");
		Student newStudent2 = new Student("Dohan", "Kakatkat","sohan@gmail.com");
		Student newStudent3 = new Student("Divynak", "Agarwal","goldy@gmail.com");

		System.out.println("Saving 3 new Student");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

	}

}
