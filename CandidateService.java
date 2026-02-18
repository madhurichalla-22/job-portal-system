package com.jobportal.system.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.system.entity.Candidate;
import com.jobportal.system.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate register(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate login(String email,String password){
        Candidate candidate = candidateRepository.findByEmailAndPassword(email,password);

        if(candidate == null){
            throw new RuntimeException("Invalid email or password");
        }

        return candidate;
    }
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}