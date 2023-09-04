package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ApplicationRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Transcript transcript = new Transcript("75%");
			String email = "Ahmed@gmail.com";
			Application application = new Application(
					"Jamel" ,
					"Ahmed" ,
					email,
					transcript,
					LocalDateTime.now()

			);
			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, application);

			repository.findApplicationByEmailContains(email).ifPresentOrElse(a -> {System.out.println(a + " already exists");}, ()->{System.out.println("Inserting application "+ application);
				repository.insert(application);});
		};

	}

	private static void usingMongoTemplateAndQuery(ApplicationRepository repository, MongoTemplate mongoTemplate, String email, Application application) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Application> applications = mongoTemplate.find(query, Application.class);

		if(applications.size() > 1){
			throw new IllegalStateException("found many students with email");
		}
		if (applications.isEmpty()){
			System.out.println("Inserting application "+ application);
			repository.insert(application);
		}
		else{
			System.out.println(application + " already exists");
		}
	}

}
