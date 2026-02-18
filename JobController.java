package com.jobportal.system.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.system.entity.Job;
import com.jobportal.system.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/post/{employerId}")
    public Job postJob(@RequestBody Job job,
                       @PathVariable("employerId") Long employerId) {

        return jobService.postJob(job, employerId);
    }


    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    @GetMapping("/employer/{id}")
    public List<Job> getJobsByEmployer(@PathVariable("id") Long id){
    	return jobService.getJobsByEmployer(id);

    
    }


}
