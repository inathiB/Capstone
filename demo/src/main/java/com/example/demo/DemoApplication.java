package com.example.demo;

import com.example.demo.Collection.Course;
import com.example.demo.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner (CourseRepository repository ){
		return args -> {

			Course course = new Course("CSC2015","Introduction to Programming");

			/*
			CourseController controller = new CourseController();
			* */
			/*controller.addLecturerToCourse("csc1015",new Lecturer("Rea"));*/
			repository.findCourseByCourseCode(course.getCourseCode()). // Call the controller
					ifPresentOrElse(c -> {
						System.out.println("already exists");},

							()-> {System.out.println("Not Present");
									repository.insert(course);});
			};
		}

	}




