package com.jobportal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.system.entity.Application;
import com.jobportal.system.entity.Candidate;
import com.jobportal.system.entity.Job;
import com.jobportal.system.repository.ApplicationRepository;
import com.jobportal.system.repository.CandidateRepository;
import com.jobportal.system.repository.JobRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    public void apply(Long candidateId, Long jobId){

        if(applicationRepository.existsByCandidateIdAndJobId(candidateId, jobId)){
            throw new RuntimeException("Already applied");
        }

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application app = new Application();
        app.setCandidate(candidate);
        app.setJob(job);

        applicationRepository.save(app);
    }

    // GET APPLICATIONS BY CANDIDATE
    public List<Application> getApplicationsByCandidate(Long candidateId){
        return applicationRepository.findByCandidateId(candidateId);
    }

    // CHECK APPLIED
    public boolean alreadyApplied(Long candidateId, Long jobId){
        return applicationRepository.existsByCandidateIdAndJobId(candidateId, jobId);
    }
}