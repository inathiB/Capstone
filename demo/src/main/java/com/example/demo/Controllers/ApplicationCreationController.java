package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/applicationcreation")
@AllArgsConstructor
public class ApplicationCreationController {
    private final ApplicationCreationService applicationCreationService;
    @GetMapping
    public List<ApplicationCreation> fetchAllApplicationCreations(){
        return applicationCreationService.getAllApplicationCreations();
    };
    @GetMapping("/aplliacationCreation{department}")
    public ApplicationCreation getApplicationCreation(@ PathVariable String department) {
        return applicationCreationService.getApplicationCreation(department);}

    @PostMapping
    public void addApplicationCreation(@RequestBody ApplicationCreation applicationCreation){
        applicationCreationService.addAppplicationCreation(applicationCreation);}

    @DeleteMapping("/{department}")
    public void deleteApplicationCreation(@PathVariable String department){
        ApplicationCreationService.deleteApplicatioCreation(department);}
}
