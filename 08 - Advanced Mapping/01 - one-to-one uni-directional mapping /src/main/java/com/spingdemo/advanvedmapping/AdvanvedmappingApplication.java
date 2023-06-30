package com.spingdemo.advanvedmapping;

import com.spingdemo.advanvedmapping.dao.AppDAO;
import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
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

}
