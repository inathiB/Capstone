package com.example.demo.Logic;

import com.example.demo.Collection.ApplicationCreation;
import com.example.demo.Email.EmailService;
import com.example.demo.Repository.ApplicationCreationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class ApplicationCreationService {

    private final ApplicationCreationRepository applicationCreationRepository;
    private final EmailService emailService;
    public ApplicationCreation getApplicationCreation(String department){
        Optional<ApplicationCreation> optionalApplicationCreation = applicationCreationRepository.findApplicationCreationByDepartment(department);
        return optionalApplicationCreation.orElse(null);

    } public List<ApplicationCreation> getAllApplicationCreations(){
        return applicationCreationRepository.findAll();
    }
    public void addApplicationCreation (ApplicationCreation applicationCreation){

        applicationCreationRepository.insert(applicationCreation);
    }
    public void deleteApplicationCreation(String department){
        applicationCreationRepository.deleteById(department);
    }

}
