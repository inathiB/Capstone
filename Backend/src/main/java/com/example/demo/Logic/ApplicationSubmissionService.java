package com.example.demo.Logic;

import com.example.demo.Collection.ApplicationSubmission;
import com.example.demo.Repository.ApplicationSubmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@AllArgsConstructor
@Service
public class ApplicationSubmissionService {
    private final ApplicationSubmissionRepository applicationSubmissionRepository;

    public ApplicationSubmission getApplicationSubmission(String studentNumber) {
        Optional<ApplicationSubmission> optionalApplicationSubmission = applicationSubmissionRepository.findApplicationSubmissionByStudentNumber(studentNumber);

        return optionalApplicationSubmission.orElse(null);
    }
    public List<ApplicationSubmission>getAllApplicationSubmissions(){
            return applicationSubmissionRepository.findAll();
    }
    public void addApplicationSubmission(ApplicationSubmission applicationSubmission){
            applicationSubmissionRepository.insert(applicationSubmission);
    }
    public void deleteApplicationSubmission (String studentNumber){
            applicationSubmissionRepository.deleteById(studentNumber);
    }
}