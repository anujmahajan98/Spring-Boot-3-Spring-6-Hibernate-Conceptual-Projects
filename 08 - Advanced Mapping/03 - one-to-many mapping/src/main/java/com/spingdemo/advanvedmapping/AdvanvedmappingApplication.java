package com.spingdemo.advanvedmapping;

import com.spingdemo.advanvedmapping.dao.AppDAO;
import com.spingdemo.advanvedmapping.entity.Course;
import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanvedmappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanvedmappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetailsById(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourse(appDAO);
			//findInstructorWithCourses(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theID = 10;
		System.out.println("Deleting the Course Details with ID : " + theID);
		appDAO.deleteCoursebyID(theID);
	}

	private void updateCourse(AppDAO appDAO) {
		int theID = 10;
		System.out.println("Finding the Course Details with ID : " + theID);
		Course tempCourse = appDAO.findCourseByID(theID);
		System.out.println("Updating the Course Details with ID : " + theID);
		tempCourse.setTitle("Advance Database Concepts");
		appDAO.updateCourse(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theID = 2;
		System.out.println("Finding the Instructor Details with ID : " + theID);
		Insructor tempInstructor = appDAO.findInstructorByID(theID);
		System.out.println("Updating the Instructor Details with ID : " + theID);
		tempInstructor.setFirstName("Tanmay");
		tempInstructor.setLastName("Sangwan");
		appDAO.updateInstructor(tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the Instructor Details with ID : " + theId);
		Insructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor -> " + tempInstructor);
		System.out.println("Associated Courses -> " + tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding the Instructor Details with ID : " + theId);
		Insructor tempInstructor = appDAO.findInstructorByID(theId);
		System.out.println("Instructor -> " + tempInstructor);

		List<Course> courses = appDAO.findCourseByInstructorId(theId);

		tempInstructor.setCourses(courses);
		System.out.println("Associated Courses -> " + tempInstructor.getCourses());

	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		Insructor tempInstructor = new Insructor("Anuj", "Mahajan", "anuj@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.anuj.com", "Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Applied Algorithms");
		Course tempCourse2 = new Course("Data Mining");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving the Instructor : " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done saving");
	}

	private void findInstructorDetailsById(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the Instructor Details with ID : " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailsByID(theId);
		System.out.println("Instructor -> " + tempInstructorDetail.getInstructor());
		System.out.println("Instructor Detail -> " + tempInstructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting the Instructor with ID : " + theId);
		appDAO.deletInstructor(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor with ID : " + theId);
		Insructor tempInstructor = appDAO.findInstructorByID(theId);
		System.out.println("Instructor -> " + tempInstructor);
		System.out.println("Instructor Detail -> " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDao){
		Insructor tempInstructor = new Insructor("Anuj", "Mahajan", "anuj@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.example.com", "Badminton");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving the Instructor : " + tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done saving");
	}

	private void deleteInstructorDetail(AppDAO appDao){
		int theId = 2;
		System.out.println("Deleting the Instructor Details with ID : " + theId);
		appDao.deleteInstructorDetail(theId);
	}

}
