package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationSubmissionRepository extends MongoRepository<ApplicationSubmission, String> {
    Optional<ApplicationSubmission> findApplicationSubmissionByStudentNoContains(String studentNo);

}
