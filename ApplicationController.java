package com.jobportal.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.system.entity.Application;
import com.jobportal.system.service.ApplicationService;

@RestController
@RequestMapping("/application")
@CrossOrigin
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // APPLY JOB
    @PostMapping("/apply/{candidateId}/{jobId}")
    public String applyJob(@PathVariable("candidateId") Long candidateId,
                           @PathVariable("jobId") Long jobId) {

        applicationService.apply(candidateId, jobId);
        return "Applied successfully";
    }

    // GET APPLICATIONS
    @GetMapping("/candidate/{candidateId}")
    public List<Application> getApplications(@PathVariable("candidateId") Long candidateId){
        return applicationService.getApplicationsByCandidate(candidateId);
    }
}