package com.example.demo.Repository;

import com.example.demo.Collection.ApplicationSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationSubmissionRepository extends MongoRepository<ApplicationSubmission, String> {
    Optional<ApplicationSubmission> findApplicationSubmissionByStudentNo(String studentNo);

}
