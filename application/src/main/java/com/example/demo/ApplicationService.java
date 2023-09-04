package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    public List<Application> getAllApplications(){
        return applicationRepository.findAll();

    }
}
