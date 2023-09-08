package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationCreationRepository extends MongoRepository<ApplicationCreation, String> {
    Optional<ApplicationCreation> findApplicationCreationByDepartmentContains(String Department);

}
