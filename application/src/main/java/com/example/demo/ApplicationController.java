package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/application")
@AllArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;
    @GetMapping
    public List<Application> fetchAllApplications(){
        return applicationService.getAllApplications();
    };
}
