package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ApplicationCreationService {

    private final ApplicationCreationRepository applicationCreationRepository;
    public ApplicationCreation getApplicationCreation(department){
        Optional<ApplicationCreation> optionalApplicationCreation = applicationCreationRepository.findApplicationCreationByDepartment(department);
        return optionalApplicationCreation.orElse(null);
    } List<ApplicationCreation> getAllApplicationCreations(){
        return applicationCreationRepository.findAll();
    }
    public void addApplicationCreation (ApplicationCreation applicationCreation){
        applicationCreationRepository.insert(applicationCreation);
    }
    public void deleteApplicationCreation(String courseID){
        applicationCreationRepository.deleteByDepartment(department);
    }

}
