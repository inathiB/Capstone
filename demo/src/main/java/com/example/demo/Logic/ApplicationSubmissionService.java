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

    public ApplicationSubmission getApplicationSubmission(String studentNo) {
        Optional<ApplicationSubmission> optionalApplicationSubmission = applicationSubmissionRepository.findApplicationSubmissionByStudentNo(studentNo);

        return optionalApplicationSubmission.orElse(null);
    }
    public List<ApplicationSubmission>getAllApplicationSubmissions(){
            return applicationSubmissionRepository.findAll();
    }
    public void addApplicationSubmission(ApplicationSubmission applicationSubmission){
            applicationSubmissionRepository.insert(applicationSubmission);
    }
    public void deleteApplicationSubmission (String studentNo){
            applicationSubmissionRepository.deleteById(studentNo);
    }
}