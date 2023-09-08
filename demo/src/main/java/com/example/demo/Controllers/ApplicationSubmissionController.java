package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/applicationsubmission")
@AllArgsConstructor
public class ApplicationSubmissionController {
    private final ApplicationSubmissionService applicationSubmissionService;
    @GetMapping
    public List<ApplicationSubmission> fetchAllApplicationSubmissions(){
        return applicationSubmissionService.getAllApplicationSubmissions();
    };

    @GetMapping("/applicationSubmission{studentNo}")
    public ApplicationSubmission getAllApplicationSubmission(@ PathVariable String studentNo) {
        return applicationSubmissionService.getApplicationSubmission(studentNo);}
    @PostMapping
    public void addApplicationSubmission(@RequestBody ApplicationSubmission applicationSubmission){
        applicationSubmissionService.addAppplicatioSubmission(applicationSubmission);}

    @DeleteMapping("/{studentNo}")
    public void deleteApplicationSubmissionCreation(@PathVariable String studentNo){
        ApplicationSubmissionService.deleteApplicatioSUbmission(studentNo);}
}

