package com.example.demo.Controllers;

import com.example.demo.Collection.ApplicationCreation;
import com.example.demo.Logic.ApplicationCreationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ApplicationCreation getApplicationCreation(@PathVariable String department) {
        return applicationCreationService.getApplicationCreation(department);}

    @PostMapping
    public void addApplicationCreation(@RequestBody ApplicationCreation applicationCreation){
        applicationCreationService.addApplicationCreation(applicationCreation);}

    @DeleteMapping("/{id}")
    public void deleteApplicationCreation(@PathVariable String id){
        applicationCreationService.deleteApplicationCreation(id);}
}
