package com.example.demo.Controllers;

import com.example.demo.Collection.ApplicationSubmission;
import com.example.demo.Logic.ApplicationSubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ApplicationSubmission getAllApplicationSubmission(@PathVariable String studentNo) {
        return applicationSubmissionService.getApplicationSubmission(studentNo);}
    @PostMapping
    public void addApplicationSubmission(@RequestBody ApplicationSubmission applicationSubmission){
        applicationSubmissionService.addApplicationSubmission(applicationSubmission);}

    @DeleteMapping("/{id}")
    public void deleteApplicationSubmission(@PathVariable String id){
        applicationSubmissionService.deleteApplicationSubmission(id);}
}

