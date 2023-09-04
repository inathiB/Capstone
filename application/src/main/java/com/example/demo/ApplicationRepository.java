package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    Optional<Application> findApplicationByEmailContains(String email);

}
