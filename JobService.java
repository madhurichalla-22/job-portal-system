package com.jobportal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.system.entity.Job;
import com.jobportal.system.repository.JobRepository;
import com.jobportal.system.repository.EmployerRepository;
import com.jobportal.system.entity.Employer;
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    public Job postJob(Job job, Long employerId) {

        Employer employer = employerRepository
                .findById(employerId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        job.setEmployer(employer);

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByEmployer(Long employerId) {
        return jobRepository.findByEmployerId(employerId);
    }
}
