package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ApplicationSubmissionService {

    private final ApplicationSubmissionRepository applicationSubmissionRepository;
    public ApplicationSubmission getApplicationSubmission(department){
        Optional<ApplicationSubmission> optionalApplicationSubmission = applicationSubmissionRepository.findApplicationSubmissionCreationByStudentNo(studentNo);
        return optionalApplicationSubmission.orElse(null);

        public List<ApplicationSubmission> getAllApplicationSubmissions(){
        return applicationSubmissionRepository.findAll();
        }
        public void addApplicationSubmission (ApplicationSubmission applicationSubmission){
            applicationSubmissionRepository.insert(applicationSubmission);
        }
        public void deleteApplicationSubmission(String studentNo){
            applicationSubmissionRepository.deleteByStudentNo(studentNo);
        }
    }
